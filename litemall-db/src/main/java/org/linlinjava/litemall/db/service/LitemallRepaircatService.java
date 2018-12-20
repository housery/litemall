package org.linlinjava.litemall.db.service;

import org.linlinjava.litemall.db.dao.LitemallRepaircatMapper;
import org.linlinjava.litemall.db.domain.LitemallRepaircat;
import org.linlinjava.litemall.db.domain.LitemallRepaircatExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/17 19:44
 * @email: 1126457667@qq.com
 */
@Service
public class LitemallRepaircatService {
    @Resource
    private LitemallRepaircatMapper repaircatMapper;

    public int add(LitemallRepaircat repaircat){
        return repaircatMapper.insert(repaircat);
    }

    public int delete(Integer id){
        return repaircatMapper.deleteByPrimaryKey(id);
    }

    public List<LitemallRepaircat> findAll(){
        LitemallRepaircatExample example = new LitemallRepaircatExample();
        return repaircatMapper.selectByExample(example);
    }
}
