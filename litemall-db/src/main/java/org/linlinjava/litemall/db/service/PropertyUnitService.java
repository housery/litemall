package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallPropertyUnitMapper;
import org.linlinjava.litemall.db.domain.LitemallPropertyUnit;
import org.linlinjava.litemall.db.domain.LitemallPropertyUnitExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 21:53
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyUnitService {
    @Resource
    private LitemallPropertyUnitMapper unitMapper;
    @Autowired
    private PropertyDoornumService doornumService;

    /**
     * 根据社区id获取单元列表
     * @param communityId 社区id
     * @return 单元列表
     */
    public List<LitemallPropertyUnit> getUnitListByCommId(Integer communityId){
        LitemallPropertyUnitExample example = new LitemallPropertyUnitExample();
        example.or().andCommunityIdEqualTo(communityId);
        return unitMapper.selectByExample(example);
    }

    public int add(LitemallPropertyUnit unit){
        return unitMapper.insertSelective(unit);
    }

    public int delete(Integer id, Integer communityId){
        if (doornumService.getDoonumByUnitIdCommId(id,communityId) == null){
            return 0; // 单元下有房屋无法删除
        }
        return unitMapper.deleteByPrimaryKey(id);
    }

}
