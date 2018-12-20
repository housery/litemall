package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyCommunity;
import org.linlinjava.litemall.db.service.PropertyCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 社区服务
 * @author: xiaohoo
 * @date: 2018/12/17 22:34
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/community")
@Validated
@Api(tags = "admin物业社区服务")
public class AdminCommunityController {
    @Autowired
    private PropertyCommunityService communityService;

    @PostMapping("/add")
    @ApiOperation("添加社区")
    public Object add(@LoginAdmin Integer adminId, @NotNull String communityName){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        LitemallPropertyCommunity community = new LitemallPropertyCommunity();
        community.setCommunityName(communityName);
        communityService.add(community);
        return ResponseUtil.ok();
    }

    @GetMapping("/delete")
    @ApiOperation("删除社区")
    public Object delete(@LoginAdmin Integer adminId, @NotNull Integer id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = communityService.delete(id);
        if(result == 0){
            return ResponseUtil.fail(400,"删除失败，请先删除该小区下的所有单元");
        }
        return ResponseUtil.ok();
    }
}
