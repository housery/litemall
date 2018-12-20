package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornum;
import org.linlinjava.litemall.db.service.PropertyDoornumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 23:57
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/doonum")
@Validated
@Api(tags = "物业户号服务")
public class WebDoornumController {

    @Autowired
    private PropertyDoornumService doornumService;

    @GetMapping("/getDoonumByUnitId")
    @ApiOperation("根据单元id获取户号列表")
    public Object getDoonumByUnitId(Integer unitId,Integer communityId){
       List<LitemallPropertyDoornum> doornumList = doornumService.getDoonumByUnitIdCommId(unitId,communityId);
        return ResponseUtil.ok(doornumList);
    }
}
