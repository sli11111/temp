package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.domain.SpRecord;
import com.scfsoft.dao.mybatis.SpRecordMapper;
import com.scfsoft.domain.SpRecordExample;

@Service
public class SpRecordService {

    @Resource
    private SpRecordMapper spRecordMapper;


    public long countByExample(SpRecordExample example) {
        return spRecordMapper.countByExample(example);
    }


    public int deleteByExample(SpRecordExample example) {
        return spRecordMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String categorys) {
        return spRecordMapper.deleteByPrimaryKey(categorys);
    }


    public int insert(SpRecord record) {
        return spRecordMapper.insert(record);
    }


    public int insertOrUpdate(SpRecord record) {
        return spRecordMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpRecord record) {
        return spRecordMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpRecord record) {
        return spRecordMapper.insertSelective(record);
    }


    public List<SpRecord> selectByExample(SpRecordExample example) {
        return spRecordMapper.selectByExample(example);
    }


    public SpRecord selectByPrimaryKey(String categorys) {
        return spRecordMapper.selectByPrimaryKey(categorys);
    }


    public int updateByExampleSelective(SpRecord record, SpRecordExample example) {
        return spRecordMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpRecord record, SpRecordExample example) {
        return spRecordMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpRecord record) {
        return spRecordMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpRecord record) {
        return spRecordMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpRecord> list) {
        return spRecordMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpRecord> list) {
        return spRecordMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpRecord> list) {
        return spRecordMapper.batchInsert(list);
    }

}



