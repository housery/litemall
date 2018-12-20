package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallRepaircat2Mapper;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2;
import org.linlinjava.litemall.db.domain.LitemallRepaircat2Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 20:27
 * @email: 1126457667@qq.com
 */
@Service
public class LitemallRepaircat2Service {
    @Resource
    private LitemallRepaircat2Mapper repaircat2Mapper;

    public int add(LitemallRepaircat2 repaircat2){
        return repaircat2Mapper.insert(repaircat2);
    }

    public int delete(Integer id){
        return repaircat2Mapper.deleteByPrimaryKey(id);
    }

    public int update(LitemallRepaircat2 repaircat2){
        return repaircat2Mapper.updateByPrimaryKeySelective(repaircat2);
    }

    public List<LitemallRepaircat2> getRepaircat2ListByCat1Id(Integer repaircatId){
        LitemallRepaircat2Example example = new LitemallRepaircat2Example();
        example.or().andRepaircatIdEqualTo(repaircatId);
        return repaircat2Mapper.selectByExample(example);
    }

    public LitemallRepaircat2 getRepaircat2ById(Integer id){
        return repaircat2Mapper.selectByPrimaryKey(id);
    }
}
