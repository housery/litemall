package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepair;
import org.linlinjava.litemall.db.service.LitemallRepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author: xiaohoo
 * @date: 2018/12/19 12:24
 * @email: 1126457667@qq.com
 */

@RestController
@RequestMapping("/admin/repair")
@Validated
@Api(tags = "admin维修订单服务")
public class AdminRepairController {
    @Autowired
    private LitemallRepairService repairService;
    Logger logger = LoggerFactory.getLogger(AdminRepairController.class);

    @PostMapping("/update")
    @ApiOperation("修改维修订单")
    public Object update(@LoginAdmin Integer adminId, LitemallRepair repair){
        repair.setUpdateDate(LocalDateTime.now());
        if (adminId ==  null){
            return ResponseUtil.unlogin();
        }
        int result = repairService.update(repair);
        if (result == 0){
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/delete")
    @ApiOperation("删除维修订单")
    public Object delete(@LoginAdmin Integer adminId, Integer repairId){
        if (adminId ==  null){
            return ResponseUtil.unlogin();
        }
        if (StringUtils.isEmpty(repairId)){
            return ResponseUtil.badArgument();
        }
        repairService.delete(repairId);
        return ResponseUtil.ok();
    }

}
