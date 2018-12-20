package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2;
import org.linlinjava.litemall.db.service.LitemallRepaircat2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 二级维修服务
 * @author: xiaohoo
 * @date: 2018/12/17 20:49
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/repair")
@Validated
@Api(tags = "报修二级报修服务")
public class WebRepaircat2Controller {
    @Autowired
    private LitemallRepaircat2Service repaircat2Service;

    @PostMapping("/getRepaircat2ListByCat1Id")
    @ApiOperation("根据一级分类id获取二级分类列表")
    public Object getByCat1Id(@NotNull Integer repaircat_id){
        List<LitemallRepaircat2> repaircat2List = null;
        try {
            repaircat2List = repaircat2Service.getRepaircat2ListByCat1Id(repaircat_id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.badArgument();
        }
        return ResponseUtil.ok(repaircat2List);
    }
}
