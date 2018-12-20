package org.linlinjava.litemall.db.service;

import com.github.pagehelper.PageHelper;
import org.linlinjava.litemall.db.dao.LitemallRepairMapper;
import org.linlinjava.litemall.db.domain.LitemallRepair;
import org.linlinjava.litemall.db.domain.LitemallRepairExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 13:38
 * @email: 1126457667@qq.com
 */
@Service
public class LitemallRepairService {

    @Resource
    private LitemallRepairMapper repairMapper;

    public int add(LitemallRepair repair){
        repair.setPaymentStatus(0); // 设置支付状态为0 未支付
        repair.setUpdateDate(LocalDateTime.now());
        if (repair.getRepairType() == 1){ // 维修类型为1公修
            repair.setPaymoney(new BigDecimal(0.00));  // 公共维修则支付为0
        }
        return repairMapper.insert(repair);
    }

    public int update(LitemallRepair repair){
        repair.setUpdateDate(LocalDateTime.now());
        return repairMapper.updateByPrimaryKeySelective(repair);
    }

    public void delete(Integer id){
        repairMapper.deleteByPrimaryKey(id);
    }

    public void deleteByUserId(Integer repairId,Integer userId){
        LitemallRepairExample example = new LitemallRepairExample();
        example.or().andIdEqualTo(repairId).andMemberIdEqualTo(userId);
        repairMapper.deleteByExample(example);
    }

    public LitemallRepair findById(Integer id){
        return repairMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据会员id获取维修订单
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    public List<LitemallRepair> getRepairByMemberID(Integer userId, Integer page, Integer limit){
        LitemallRepairExample example = new LitemallRepairExample();
        LitemallRepairExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andMemberIdEqualTo(userId);
        }

        PageHelper.startPage(page, limit);
        return repairMapper.selectByExample(example);
    }

    /**
     * 根据会员id，维修状态获取维修列表
     * @param member_id
     * @param status
     * @param page
     * @param limit
     * @return
     */
    public List<LitemallRepair> getRepairByMemberIDStatus(Integer member_id, Integer status, Integer page, Integer limit){
        LitemallRepairExample example = new LitemallRepairExample();
        LitemallRepairExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(member_id)) {
            criteria.andMemberIdEqualTo(member_id);
        }
        if (!StringUtils.isEmpty(status)) {
            criteria.andStatusEqualTo(status);
        }
        PageHelper.startPage(page, limit);
        return repairMapper.selectByExample(example);
    }

    public List<LitemallRepair> getRepairByPayStatus(Integer member_id, Integer payment_status, Integer page, Integer limit){
        LitemallRepairExample example = new LitemallRepairExample();
        LitemallRepairExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(member_id)) {
            criteria.andMemberIdEqualTo(member_id);
        }
        if (!StringUtils.isEmpty(payment_status)) {
            criteria.andPaymentStatusEqualTo(payment_status);
        }
        PageHelper.startPage(page, limit);
        return repairMapper.selectByExample(example);
    }

    public List<LitemallRepair> getRepairByCommentStatus(Integer member_id, Integer comment_status, Integer page, Integer limit){
        LitemallRepairExample example = new LitemallRepairExample();
        LitemallRepairExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(member_id)) {
            criteria.andMemberIdEqualTo(member_id);
        }
        if (!StringUtils.isEmpty(comment_status)) {
            criteria.andCommentStatusEqualTo(comment_status);
        }
        PageHelper.startPage(page, limit);
        return repairMapper.selectByExample(example);
    }

}
