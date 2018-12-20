package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallPropertyCommunityMapper;
import org.linlinjava.litemall.db.domain.LitemallPropertyCommunity;
import org.linlinjava.litemall.db.domain.LitemallPropertyCommunityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 21:52
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyCommunityService {
    @Resource
    private LitemallPropertyCommunityMapper communityMapper;
    @Autowired
    private PropertyUnitService unitService;

    public int add(LitemallPropertyCommunity community){
        return communityMapper.insertSelective(community);
    }

    public int delete(Integer id){
        if (unitService.getUnitListByCommId(id) == null){
            return 0; // 删除失败，社区下边含有单元列表
        }
        return communityMapper.deleteByPrimaryKey(id);
    }

    public List<LitemallPropertyCommunity> findAll(){
        LitemallPropertyCommunityExample example = new LitemallPropertyCommunityExample();
        return communityMapper.selectByExample(example);
    }
}
