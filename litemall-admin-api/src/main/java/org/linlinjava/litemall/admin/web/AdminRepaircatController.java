package org.linlinjava.litemall.admin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.admin.annotation.LoginAdmin;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallRepaircat;
import org.linlinjava.litemall.db.service.LitemallRepaircatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 19:55
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/repaircat")
@Validated
@Api(tags = "admin维修一级维修分类")
public class AdminRepaircatController {

    @Autowired
    private LitemallRepaircatService repaircatService;

    @PostMapping("/addRepairCat")
    @ApiOperation("添加一级维修分类")
    public Object add(@LoginAdmin Integer adminId, String catName){
        if (adminId == null) {
            return ResponseUtil.unlogin();
        }
        if (StringUtils.isEmpty(catName)){
            return ResponseUtil.badArgument();
        }
        LitemallRepaircat repaircat = new LitemallRepaircat();
        repaircat.setCategory(catName);
        repaircatService.add(repaircat);
        return ResponseUtil.ok();
    }

    @GetMapping("/delete")
    @ApiOperation("删除一级维修分类")
    public Object delete(@LoginAdmin Integer adminId, Integer id){
        if (adminId == null) {
            return ResponseUtil.unlogin();
        }
        if (StringUtils.isEmpty(id)){
            return ResponseUtil.badArgument();
        }
        repaircatService.delete(id);
        return ResponseUtil.ok();
    }

}
