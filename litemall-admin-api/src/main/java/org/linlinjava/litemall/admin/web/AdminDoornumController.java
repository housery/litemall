package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornum;
import org.linlinjava.litemall.db.service.PropertyDoornumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 23:35
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/doonum")
@Validated
@Api(tags = "admin物业户号服务")
public class AdminDoornumController {
    @Autowired
    private PropertyDoornumService doornumService;

    @GetMapping("/delete")
    @ApiOperation("删除户号")
    public Object delete(@LoginAdmin Integer adminId, @NotNull Integer id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        doornumService.delete(id);
        return ResponseUtil.ok();
    }

    @PostMapping("/add")
    @ApiOperation("添加户号")
    public Object add(@LoginAdmin Integer adminId, Integer door_num, Integer unitId, Integer community_id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        LitemallPropertyDoornum doornum = new LitemallPropertyDoornum();
        doornum.setUnitId(unitId);
        doornum.setDoorNum(door_num);
        doornum.setCommunityId(community_id);
        return doornumService.add(doornum);
    }
}
