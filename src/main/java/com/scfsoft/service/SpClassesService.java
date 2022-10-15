package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.domain.SpClassesExample;
import com.scfsoft.dao.mybatis.SpClassesMapper;
import com.scfsoft.domain.SpClasses;

@Service
public class SpClassesService {

    @Resource
    private SpClassesMapper spClassesMapper;


    public long countByExample(SpClassesExample example) {
        return spClassesMapper.countByExample(example);
    }


    public int deleteByExample(SpClassesExample example) {
        return spClassesMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String csId) {
        return spClassesMapper.deleteByPrimaryKey(csId);
    }


    public int insert(SpClasses record) {
        return spClassesMapper.insert(record);
    }


    public int insertOrUpdate(SpClasses record) {
        return spClassesMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpClasses record) {
        return spClassesMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpClasses record) {
        return spClassesMapper.insertSelective(record);
    }


    public List<SpClasses> selectByExample(SpClassesExample example) {
        return spClassesMapper.selectByExample(example);
    }


    public SpClasses selectByPrimaryKey(String csId) {
        return spClassesMapper.selectByPrimaryKey(csId);
    }


    public int updateByExampleSelective(SpClasses record, SpClassesExample example) {
        return spClassesMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpClasses record, SpClassesExample example) {
        return spClassesMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpClasses record) {
        return spClassesMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpClasses record) {
        return spClassesMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpClasses> list) {
        return spClassesMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpClasses> list) {
        return spClassesMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpClasses> list) {
        return spClassesMapper.batchInsert(list);
    }

}



