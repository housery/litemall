package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallPropertyHouseMapper;
import org.linlinjava.litemall.db.domain.LitemallPropertyHouse;
import org.linlinjava.litemall.db.domain.LitemallPropertyHouseExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 21:54
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyHouseService {
    @Resource
    private LitemallPropertyHouseMapper houseMapper;

    public int add(LitemallPropertyHouse house){
        house.setCreateDate(LocalDateTime.now());
        return houseMapper.insertSelective(house);
    }

    public int delete(Integer id){
        return houseMapper.deleteByPrimaryKey(id);
    }

    public int update(LitemallPropertyHouse house){
        LitemallPropertyHouseExample example = new LitemallPropertyHouseExample();
        return houseMapper.updateByExampleSelective(house,example);
    }

    public List<LitemallPropertyHouse> findAllHouse(){
        LitemallPropertyHouseExample example = new LitemallPropertyHouseExample();
        return houseMapper.selectByExample(example);
    }

    public LitemallPropertyHouse getHouseById(Integer id){
        return houseMapper.selectByPrimaryKey(id);
    }

    public LitemallPropertyHouse getHouseByCUDId(Integer community_id, Integer unit_id, Integer doornum_id){
        LitemallPropertyHouseExample example = new LitemallPropertyHouseExample();
        example.or().andCommunityIdEqualTo(community_id).andUnitIdEqualTo(unit_id).andDoornumIdEqualTo(doornum_id);
        return houseMapper.selectOneByExample(example);
    }
}
