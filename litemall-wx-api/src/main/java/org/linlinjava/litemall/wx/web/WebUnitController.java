package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyUnit;
import org.linlinjava.litemall.db.service.PropertyUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 23:25
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/unit")
@Validated
@Api(tags = "物业单元服务")
public class WebUnitController {
    @Autowired
    private PropertyUnitService unitService;

    @GetMapping("/findAll")
    @ApiOperation("根据社区id获取单元列表")
    public Object findAll(Integer communityId){
        List<LitemallPropertyUnit> unitList = unitService.getUnitListByCommId(communityId);
        return ResponseUtil.ok(unitList);
    }
}
