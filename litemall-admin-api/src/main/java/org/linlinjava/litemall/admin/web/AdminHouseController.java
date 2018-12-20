package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyHouse;
import org.linlinjava.litemall.db.service.PropertyHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/18 10:46
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/house")
@Validated
@Api(tags = "admin物业物业房屋服务")
public class AdminHouseController {
    @Autowired
    private PropertyHouseService houseService;

    @GetMapping("/getAllHouse")
    @ApiOperation("管理员获取所有房屋")
    public Object findAllHouse(@LoginAdmin Integer adminId){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        List<LitemallPropertyHouse> houseList = houseService.findAllHouse();
        return ResponseUtil.ok(houseList);
    }

    @GetMapping("/delete")
    @ApiOperation("管理员根据房屋id删除房屋对象")
    public Object delete(@LoginAdmin Integer adminId, Integer id){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = houseService.delete(id);
        if (result != 0){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.serious(); // 删除失败
        }
    }

    @PostMapping("/add")
    @ApiOperation("管理员体添加房屋对象")
    public Object add(@LoginAdmin Integer adminId, Integer community_id, Integer unit_id, Integer doornum_id,
                      String community_name, String unit_name, String doornum,
                      Double house_area, BigDecimal monthly_fee){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }

        LitemallPropertyHouse house = new LitemallPropertyHouse();
        house.setCreateDate(LocalDateTime.now());
        house.setCommunityId(community_id);
        house.setUnitId(unit_id);
        house.setDoornumId(doornum_id);
        house.setCommunityName(community_name);
        house.setUnitName(unit_name);
        house.setDoornum(doornum);
        house.setHouseArea(house_area);
        house.setMonthlyFee(monthly_fee);

        houseService.add(house);
        return ResponseUtil.ok();
    }

    @PostMapping("/update")
    @ApiOperation("管理员更新修改房屋对象")
    public Object update(@LoginAdmin Integer adminId, LitemallPropertyHouse house){
        if (adminId == null){
            return ResponseUtil.unlogin();
        }
        int result = houseService.update(house);
        if (result == 1){
            return ResponseUtil.ok();
        }else {
            return ResponseUtil.fail();
        }
    }
}
