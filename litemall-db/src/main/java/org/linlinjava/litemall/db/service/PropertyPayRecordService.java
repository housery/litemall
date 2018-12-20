package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallPropertyPaymentRecordMapper;
import org.linlinjava.litemall.db.domain.LitemallPropertyPaymentRecord;
import org.linlinjava.litemall.db.domain.LitemallPropertyPaymentRecordExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 21:55
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyPayRecordService {
    @Resource
    private LitemallPropertyPaymentRecordMapper paymentRecordMapper;

    /**
     * 添加缴费记录
     * @param paymentRecord
     * @return
     */
    public int add(LitemallPropertyPaymentRecord paymentRecord){
        return paymentRecordMapper.insertSelective(paymentRecord);
    }

    public int delete(Integer id){
        return paymentRecordMapper.deleteByPrimaryKey(id);
    }

    public int deleteByHouseId(Integer houseId){
        LitemallPropertyPaymentRecordExample example = new LitemallPropertyPaymentRecordExample();
        example.or().andHouseIdEqualTo(houseId);
        return paymentRecordMapper.deleteByExample(example);
    }

    public LitemallPropertyPaymentRecord getPayRecordById(Integer id){
        return paymentRecordMapper.selectByPrimaryKey(id);
    }

    public List<LitemallPropertyPaymentRecord> getPayRecordListByHouseId(Integer id){
        LitemallPropertyPaymentRecordExample example = new LitemallPropertyPaymentRecordExample();
        example.or().andHouseIdEqualTo(id);
        return paymentRecordMapper.selectByExample(example);
    }

    /**
     * 根据房屋id和支付状态获取缴费记录，
     * 当pay_status = 0 可以获取房屋的未缴费记录
     * @param houseId 房屋id
     * @param pay_status 支付状态
     * @return 支付记录列表
     */
    public List<LitemallPropertyPaymentRecord> getPayRecordListByHouseIdPayStatus(Integer houseId, Integer pay_status){
        LitemallPropertyPaymentRecordExample example = new LitemallPropertyPaymentRecordExample();
        example.or().andHouseIdEqualTo(houseId).andPayStatusEqualTo(pay_status);
        return paymentRecordMapper.selectByExample(example);
    }

    /**
     * 物业缴费
     * @param paymentRecordList 支付记录中未缴费的房屋id列表
     * @return
     */
    public void payProperty(List<LitemallPropertyPaymentRecord> paymentRecordList){
        for (LitemallPropertyPaymentRecord record: paymentRecordList) {
            record.setPayStatus(1);
            paymentRecordMapper.updateByPrimaryKey(record);
        }
    }
}
