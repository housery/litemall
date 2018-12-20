package org.linlinjava.litemall.db.timerTask;

import org.linlinjava.litemall.db.domain.LitemallPropertyHouse;
import org.linlinjava.litemall.db.domain.LitemallPropertyPaymentRecord;
import org.linlinjava.litemall.db.service.PropertyHouseService;
import org.linlinjava.litemall.db.service.PropertyPayRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务
 * @author: xiaohoo
 * @date: 2018/12/12 16:47
 * @email: 1126457667@qq.com
 */
@Component
public class TimerTask {

    @Autowired
    private PropertyPayRecordService payRecordService;
    @Autowired
    private PropertyHouseService houseService;
    Logger logger = LoggerFactory.getLogger(TimerTask.class);

    /**
     * 定时插入待缴费记录
     * 每年一月一日凌晨00:00:00 自动添加物业费缴费记录，默认从房屋表中获取所有房屋id，为每个房屋添加。
     *  Cron表达式
     * {秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
     *
     * 0 0 0 1 1 ?   每年的一月一日00：00：00
     */
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void insertPayRecord(){
        List<LitemallPropertyHouse> houseList = houseService.findAllHouse();
        for (LitemallPropertyHouse house:houseList) {
            LitemallPropertyPaymentRecord paymentRecord = new LitemallPropertyPaymentRecord();
            paymentRecord.setCreateDate(LocalDateTime.now());
            paymentRecord.setHouseId(house.getId());
            paymentRecord.setPayStatus(0);  //设置支付状态为0（未支付）
            paymentRecord.setYear(LocalDateTime.now().getYear());
            // 计算待缴费金额 房屋面积*物业月费标准*12
            BigDecimal payMoney = house.getMonthlyFee().multiply(new BigDecimal(house.getHouseArea() * 12));
            paymentRecord.setPaymoney(payMoney);

            logger.debug("房屋id：" + house.getId() + " 待缴费：" + payMoney);
            payRecordService.add(paymentRecord);
        }
    }
}
