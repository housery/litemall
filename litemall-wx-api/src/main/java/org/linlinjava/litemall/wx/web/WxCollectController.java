package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallCollect;
import org.linlinjava.litemall.db.domain.LitemallGoods;
import org.linlinjava.litemall.db.service.LitemallCollectService;
import org.linlinjava.litemall.db.service.LitemallGoodsService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户收藏服务
 */
@RestController
@RequestMapping("/wx/collect")
@Validated
@Api(value = "用户收藏服务",tags = "用户收藏服务")
public class WxCollectController {
    private final Log logger = LogFactory.getLog(WxCollectController.class);

    @Autowired
    private LitemallCollectService collectService;
    @Autowired
    private LitemallGoodsService goodsService;

    /**
     * 用户收藏列表
     *
     * @param userId 用户ID
     * @param type   类型，如果是0则是商品收藏，如果是1则是专题收藏
     * @param page   分页页数
     * @param size   分页大小
     * @return 用户收藏列表
     */
    @GetMapping("list")
    @ApiOperation("用户收藏列表,参数：type(类型，如果是0则是商品收藏，如果是1则是专题收藏)")
    public Object list(@LoginUser Integer userId,
                       @NotNull Byte type,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        List<LitemallCollect> collectList = collectService.queryByType(userId, type, page, size);
        int count = collectService.countByType(userId, type);
        int totalPages = (int) Math.ceil((double) count / size);

        List<Object> collects = new ArrayList<>(collectList.size());
        for (LitemallCollect collect : collectList) {
            Map<String, Object> c = new HashMap<String, Object>();
            c.put("id", collect.getId());
            c.put("type", collect.getType());
            c.put("valueId", collect.getValueId());

            LitemallGoods goods = goodsService.findById(collect.getValueId());
            c.put("name", goods.getName());
            c.put("brief", goods.getBrief());
            c.put("picUrl", goods.getPicUrl());
            c.put("retailPrice", goods.getRetailPrice());

            collects.add(c);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("collectList", collects);
        result.put("totalPages", totalPages);
        return ResponseUtil.ok(result);
    }

    /**
     * 用户收藏添加或删除
     * <p>
     * 如果商品没有收藏，则添加收藏；如果商品已经收藏，则删除收藏状态。
     *
     * @param userId 用户ID
     * @param body   请求内容，{ type: xxx, valueId: xxx }
     * @return 操作结果
     */
    @PostMapping("addordelete")
    @ApiOperation("用户收藏添加或删除(如果商品没有收藏，则添加收藏；如果商品已经收藏，则删除收藏状态。),参数：{ type: xxx, valueId: xxx }")
    public Object addordelete(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        Byte type = JacksonUtil.parseByte(body, "type");
        Integer valueId = JacksonUtil.parseInteger(body, "valueId");
        if (!ObjectUtils.allNotNull(type, valueId)) {
            return ResponseUtil.badArgument();
        }

        LitemallCollect collect = collectService.queryByTypeAndValue(userId, type, valueId);

        String handleType = null;
        if (collect != null) {
            handleType = "delete";
            collectService.deleteById(collect.getId());
        } else {
            handleType = "add";
            collect = new LitemallCollect();
            collect.setUserId(userId);
            collect.setValueId(valueId);
            collect.setType(type);
            collectService.add(collect);
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("type", handleType);
        return ResponseUtil.ok(data);
    }
}