package org.linlinjava.litemall.wx.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPropertyPaymentRecord;
import org.linlinjava.litemall.db.service.PropertyPayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/18 13:39
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/admin/propertyPayRecord")
@Valid
@Api(tags = "物业缴费记录服务")
public class WebPayRecordController {
    @Autowired
    private PropertyPayRecordService payRecordService;

    @ApiOperation("根据物业支付记录id获取支付记录")
    @GetMapping("/getPayRecordById")
    public Object getPayRecordById(Integer id){
        LitemallPropertyPaymentRecord record = payRecordService.getPayRecordById(id);
        return ResponseUtil.ok(record);
    }

    @ApiOperation("根据房屋id获取物业缴费列表")
    @GetMapping("/getPayRecordListByHouseId")
    public Object getPayRecordListByHouseId(Integer houseId){
        List<LitemallPropertyPaymentRecord> record = null;
        try {
            record = payRecordService.getPayRecordListByHouseId(houseId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.serious();
        }
        return ResponseUtil.ok(record);
    }

    @ApiOperation("根据房屋id，缴费状态获取物业缴费列表")
    @GetMapping("/getPayRecordListByHouseIdPayStatus")
    public Object getPayRecordListByHouseIdPayStatus(Integer houseId, Integer pay_status){

        List<LitemallPropertyPaymentRecord> paymentRecords = payRecordService.getPayRecordListByHouseIdPayStatus(houseId,pay_status);
        return ResponseUtil.ok(paymentRecords);
    }
}
