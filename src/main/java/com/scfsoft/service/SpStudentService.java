package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.domain.SpStudentExample;
import com.scfsoft.dao.mybatis.SpStudentMapper;
import com.scfsoft.domain.SpStudent;

@Service
public class SpStudentService {

    @Resource
    private SpStudentMapper spStudentMapper;


    public long countByExample(SpStudentExample example) {
        return spStudentMapper.countByExample(example);
    }


    public int deleteByExample(SpStudentExample example) {
        return spStudentMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(Integer sId) {
        return spStudentMapper.deleteByPrimaryKey(sId);
    }


    public int insert(SpStudent record) {
        return spStudentMapper.insert(record);
    }


    public int insertOrUpdate(SpStudent record) {
        return spStudentMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpStudent record) {
        return spStudentMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpStudent record) {
        return spStudentMapper.insertSelective(record);
    }


    public List<SpStudent> selectByExample(SpStudentExample example) {
        return spStudentMapper.selectByExample(example);
    }


    public SpStudent selectByPrimaryKey(Integer sId) {
        return spStudentMapper.selectByPrimaryKey(sId);
    }


    public int updateByExampleSelective(SpStudent record, SpStudentExample example) {
        return spStudentMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpStudent record, SpStudentExample example) {
        return spStudentMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpStudent record) {
        return spStudentMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpStudent record) {
        return spStudentMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpStudent> list) {
        return spStudentMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpStudent> list) {
        return spStudentMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpStudent> list) {
        return spStudentMapper.batchInsert(list);
    }

}



