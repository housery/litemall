package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyUnit;
import org.linlinjava.litemall.db.service.PropertyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 23:09
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/unit")
@Validated
@Api(tags = "admin物业单元服务")
public class AdminUnitController {
    @Autowired
    private PropertyUnitService unitService;

    @GetMapping("/delete")
    @ApiOperation("删除单元")
    public Object delete(@LoginAdmin Integer adminId, Integer id, Integer communityId){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = unitService.delete(id,communityId);
        if (result == 0){
            return ResponseUtil.fail(400,"删除失败，请先删除该单元下的所有户号");
        }
        return ResponseUtil.ok();
    }

    @PostMapping("/add")
    @ApiOperation("添加单元")
    public Object add(@LoginAdmin Integer adminId, String unitName, Integer community_id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        LitemallPropertyUnit unit = new LitemallPropertyUnit();
        unit.setUnitName(unitName);
        unit.setCommunityId(community_id);
        return unitService.add(unit);
    }
}
