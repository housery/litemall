package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyCommunity;
import org.linlinjava.litemall.db.service.PropertyCommunityService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 社区服务
 * @author: xiaohoo
 * @date: 2018/12/17 22:53
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/community")
@Validated
@Api(tags = "物业社区服务")
public class WebCommunityController {
    @Autowired
    private PropertyCommunityService communityService;

    @GetMapping("/findAll")
    @ApiOperation("查找所有社区")
    public Object findAll(@LoginUser Integer userId){
        if (StringUtils.isEmpty(userId)){
            return ResponseUtil.unlogin();
        }
        List<LitemallPropertyCommunity> communityList = communityService.findAll();
        return ResponseUtil.ok(communityList);
    }
}
