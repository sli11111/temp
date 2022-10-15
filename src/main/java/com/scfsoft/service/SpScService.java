package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.scfsoft.domain.SpScExample;
import java.util.List;
import com.scfsoft.domain.SpSc;
import com.scfsoft.dao.mybatis.SpScMapper;

@Service
public class SpScService {

    @Resource
    private SpScMapper spScMapper;


    public long countByExample(SpScExample example) {
        return spScMapper.countByExample(example);
    }


    public int deleteByExample(SpScExample example) {
        return spScMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String scClassid, Integer scStuid) {
        return spScMapper.deleteByPrimaryKey(scClassid, scStuid);
    }


    public int insert(SpSc record) {
        return spScMapper.insert(record);
    }


    public int insertOrUpdate(SpSc record) {
        return spScMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpSc record) {
        return spScMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpSc record) {
        return spScMapper.insertSelective(record);
    }


    public List<SpSc> selectByExample(SpScExample example) {
        return spScMapper.selectByExample(example);
    }


    public int updateByExampleSelective(SpSc record, SpScExample example) {
        return spScMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpSc record, SpScExample example) {
        return spScMapper.updateByExample(record, example);
    }


    public int updateBatch(List<SpSc> list) {
        return spScMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpSc> list) {
        return spScMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpSc> list) {
        return spScMapper.batchInsert(list);
    }

}



