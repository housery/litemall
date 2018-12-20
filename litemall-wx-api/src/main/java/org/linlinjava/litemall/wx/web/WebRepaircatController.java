package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepaircat;
import org.linlinjava.litemall.db.service.LitemallRepaircatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 19:55
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/web/repaircat")
@Validated
@Api(tags = "报修一级维修分类")
public class WebRepaircatController {

    @Autowired
    private LitemallRepaircatService repaircatService;

    @GetMapping("/finAll")
    @ApiOperation("查询所有一级维修分类")
    public Object finAll(){
        List<LitemallRepaircat> repaircatList = null;
        try {
            repaircatList = repaircatService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            ResponseUtil.fail(500,"查询异常");
        }
        return ResponseUtil.ok(repaircatList);
    }

}
