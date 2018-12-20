package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallPropertyDoornumMapper;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornum;
import org.linlinjava.litemall.db.domain.LitemallPropertyDoornumExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 21:53
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyDoornumService {
    @Resource
    private LitemallPropertyDoornumMapper doornumMapper;

    public int add(LitemallPropertyDoornum doornum){
        return doornumMapper.insertSelective(doornum);
    }

    public int delete(Integer id){
        return doornumMapper.deleteByPrimaryKey(id);
    }

    public List<LitemallPropertyDoornum> getDoonumByUnitIdCommId(Integer unitId, Integer communityId){
        LitemallPropertyDoornumExample example = new LitemallPropertyDoornumExample();
        example.or().andUnitIdEqualTo(unitId).andCommunityIdEqualTo(communityId);
        return doornumMapper.selectByExample(example);
    }
}
