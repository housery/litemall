package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepair;
import org.linlinjava.litemall.db.service.LitemallRepairService;
import org.linlinjava.litemall.db.service.LitemallRepaircat2Service;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * 报修服务
 *
 * @author: xiaohoo
 * @date: 2018/12/17 16:21
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/repair")
@Validated
@Api(tags = "报修服务")
public class WebRepairController {
    @Autowired
    private LitemallRepairService repairService;
    @Autowired
    private LitemallRepaircat2Service repaircat2Service;
    Logger logger = LoggerFactory.getLogger(WebRepairController.class);

    @PostMapping("/add")
    @ApiOperation("添加维修订单")
    public Object add(@LoginUser @ApiIgnore Integer userId, @NotNull Integer repair_type, @NotNull Integer category_id,
                      @NotNull Integer category2_id, @NotNull String title,
                      @NotNull String content, @NotNull String address, @NotNull Long scheduled_date,
                      @RequestParam(required = false) Double paymoney,
                      @RequestParam(required = false) String imgPath1,
                      @RequestParam(required = false) String imgPath2,
                      @RequestParam(required = false) String imgPath3){

        try {
            logger.debug("添加报修：" + userId);
            LitemallRepair repair = new LitemallRepair();
            // 维修类型为公共维修，或者支付未上传支付金额则设置支付金额未0
            if(repair_type == 1 && StringUtils.isEmpty(paymoney)){
                repair.setPaymoney(new BigDecimal(0.00));
            }
            if (repair_type == 2){ //私报,设置价格
                Double labourCost  = repaircat2Service.getRepaircat2ById(category2_id).getLabourCost(); // 获取人工费用
                repair.setPaymoney(new BigDecimal(labourCost));
            }
            repair.setUpdateDate(LocalDateTime.now());
            repair.setRepairType(repair_type);
            repair.setCategoryId(category_id);
            repair.setCategory2Id(category2_id);
            repair.setTitle(title);
            repair.setContent(content);
            repair.setAddress(address);
            repair.setStatus(1); //订单待处理
            repair.setCommentStatus(0); // 设置为未评论
            // 时间戳转LocalDateTime
            repair.setScheduledDate(LocalDateTime.ofEpochSecond(scheduled_date,0,ZoneOffset.ofHours(8)));
            repair.setMemberId(userId);
            if (!StringUtils.isEmpty(imgPath1)){
                repair.setImg1(imgPath1);
            }
            if (!StringUtils.isEmpty(imgPath2)){
                repair.setImg2(imgPath2);
            }
            if (!StringUtils.isEmpty(imgPath3)){
                repair.setImg3(imgPath3);
            }
            repairService.add(repair);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.fail(500,"系统内部出错");
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/getRepairByMemberID")
    @ApiOperation("通过会员id获取报修列表")
    public Object getRepairByMemberID(@LoginUser Integer userId, Integer page, Integer limit){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        List<LitemallRepair> repairList = repairService.getRepairByMemberID(userId,page,limit);
        return ResponseUtil.ok(repairList);
    }

    @GetMapping("/getRepairByMemberIDStatus")
    @ApiOperation("通过会员id和维修状态获取报修列表")
    public Object getRepairByMemberIDStatus(@LoginUser Integer userId, Integer status, Integer page, Integer limit){
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (status == null) {
            return ResponseUtil.badArgument();
        }

        List<LitemallRepair> repairList = repairService.getRepairByMemberIDStatus(userId,status,page,limit);
        return ResponseUtil.ok(repairList);
    }

    @GetMapping("/getRepairByPayStatus")
    @ApiOperation("通过会员id和支付状态获取报修列表")
    public Object getRepairByPayStatus(@LoginUser Integer member_id, Integer payment_status, Integer page, Integer limit){
        if (member_id == null) {
            return ResponseUtil.unlogin();
        }
        if (payment_status == null) {
            return ResponseUtil.badArgument();
        }
        List<LitemallRepair> repairList = repairService.getRepairByPayStatus(member_id,payment_status,page,limit);
        return ResponseUtil.ok(repairList);
    }

    @GetMapping("/getRepairByCommentStatus")
    @ApiOperation("通过会员id和评论状态获取报修列表，参数：member_id，comment_status，page（起始页），limit（页大小）")
    public Object getRepairByCommentStatus(@LoginUser Integer member_id, Integer comment_status, Integer page, Integer limit){
        if (member_id == null) {
            return ResponseUtil.unlogin();
        }
        if (comment_status == null) {
            return ResponseUtil.badArgument();
        }
        List<LitemallRepair> repairList = repairService.getRepairByCommentStatus(member_id,comment_status,page,limit);
        return ResponseUtil.ok(repairList);
    }

    @GetMapping("/getRepairByRepairId")
    @ApiOperation("通过维修订单id获取维修订单信息")
    public Object findById(Integer repairId){
        LitemallRepair repair = null;
        try {
            if (StringUtils.isEmpty(repairId)){
                return ResponseUtil.badArgument();
            }
            repair = repairService.findById(repairId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.serious();
        }
        return ResponseUtil.ok(repair);
    }

    @GetMapping("/delete")
    @ApiOperation("根据维修id和当前登陆会员id删除维修订单")
    public Object delete(@LoginUser Integer userId, Integer repairId){
        if (userId ==  null){
            return ResponseUtil.unlogin();
        }
        if (StringUtils.isEmpty(repairId)){
            return ResponseUtil.badArgument();
        }
        repairService.deleteByUserId(repairId,userId);
        return ResponseUtil.ok();
    }
}
