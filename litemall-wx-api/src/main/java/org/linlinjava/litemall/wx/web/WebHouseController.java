package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyHouse;
import org.linlinjava.litemall.db.service.PropertyHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiaohoo
 * @date: 2018/12/18 10:34
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/house")
@Validated
@Api(tags = "物业房屋服务")
public class WebHouseController {
    @Autowired
    private PropertyHouseService houseService;

    @GetMapping("/getHouseById")
    @ApiOperation("根据房屋id获取房屋对象")
    public Object getHouseById(Integer id){
        LitemallPropertyHouse house = houseService.getHouseById(id);
        return houseService.getHouseById(id);
    }

    @GetMapping("/getHouseByCUDId")
    @ApiOperation("根据社区id，单元id，户号id获取房屋对象")
    public Object getHouseByCUDId(Integer community_id, Integer unit_id, Integer doornum_id){
        LitemallPropertyHouse house = houseService.getHouseByCUDId(community_id,unit_id,doornum_id);
        return ResponseUtil.ok(house);
    }

}
