package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.service.PropertyPayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: xiaohoo
 * @date: 2018/12/18 12:30
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/propertyPayRecord")
@Valid
@Api(tags = "admin物业缴费记录服务")
public class AdminPayRecordController {
    @Autowired
    private PropertyPayRecordService payRecordService;

    @ApiOperation("管理员根据记录id删除缴费记录")
    @GetMapping("/delete")
    public Object delete(@LoginAdmin Integer adminId, Integer id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = payRecordService.delete(id);
        if (result > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail();
        }
    }

    @ApiOperation("管理员根据房屋id删除缴费记录")
    @GetMapping("/deleteByHouseId")
    public Object deleteByHouseId(@LoginAdmin Integer adminId, Integer houseId){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = payRecordService.deleteByHouseId(houseId);
        if (result > 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail();
        }
    }
}
