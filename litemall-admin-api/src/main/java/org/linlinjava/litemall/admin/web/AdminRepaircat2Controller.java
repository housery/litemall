package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2;
import org.linlinjava.litemall.db.service.LitemallRepaircat2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二级维修服务
 * @author: xiaohoo
 * @date: 2018/12/17 20:49
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/repaircat2")
@Validated
@Api(tags = "admin维修二级报修服务")
public class AdminRepaircat2Controller {
    @Autowired
    private LitemallRepaircat2Service repaircat2Service;

    @PostMapping("/add")
    @ApiOperation("添加二级维修分类")
    public Object add(@LoginAdmin Integer adminId, LitemallRepaircat2 repaircat2){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        Integer result = repaircat2Service.add(repaircat2);
        return ResponseUtil.ok();
    }

    @GetMapping("/delete")
    @ApiOperation("删除二级维修分类")
    public Object delete(@LoginAdmin Integer adminId, Integer id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        if (StringUtils.isEmpty(id)){
            return ResponseUtil.badArgument();
        }
        repaircat2Service.delete(id);
        return ResponseUtil.ok();
    }
}
