package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.dao.mybatis.SpScoreRecordMapper;
import com.scfsoft.domain.SpScoreRecord;
import com.scfsoft.domain.SpScoreRecordExample;

@Service
public class SpScoreRecordService {

    @Resource
    private SpScoreRecordMapper spScoreRecordMapper;


    public long countByExample(SpScoreRecordExample example) {
        return spScoreRecordMapper.countByExample(example);
    }


    public int deleteByExample(SpScoreRecordExample example) {
        return spScoreRecordMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(Integer srStuid, String srCourseid, String srExamtime) {
        return spScoreRecordMapper.deleteByPrimaryKey(srStuid, srCourseid, srExamtime);
    }


    public int insert(SpScoreRecord record) {
        return spScoreRecordMapper.insert(record);
    }


    public int insertOrUpdate(SpScoreRecord record) {
        return spScoreRecordMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpScoreRecord record) {
        return spScoreRecordMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpScoreRecord record) {
        return spScoreRecordMapper.insertSelective(record);
    }


    public List<SpScoreRecord> selectByExample(SpScoreRecordExample example) {
        return spScoreRecordMapper.selectByExample(example);
    }


    public SpScoreRecord selectByPrimaryKey(Integer srStuid, String srCourseid, String srExamtime) {
        return spScoreRecordMapper.selectByPrimaryKey(srStuid, srCourseid, srExamtime);
    }


    public int updateByExampleSelective(SpScoreRecord record, SpScoreRecordExample example) {
        return spScoreRecordMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpScoreRecord record, SpScoreRecordExample example) {
        return spScoreRecordMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpScoreRecord record) {
        return spScoreRecordMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpScoreRecord record) {
        return spScoreRecordMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpScoreRecord> list) {
        return spScoreRecordMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpScoreRecord> list) {
        return spScoreRecordMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpScoreRecord> list) {
        return spScoreRecordMapper.batchInsert(list);
    }

}



