package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.domain.SpTeacher;
import com.scfsoft.dao.mybatis.SpTeacherMapper;
import com.scfsoft.domain.SpTeacherExample;

@Service
public class SpTeacherService {

    @Resource
    private SpTeacherMapper spTeacherMapper;


    public long countByExample(SpTeacherExample example) {
        return spTeacherMapper.countByExample(example);
    }


    public int deleteByExample(SpTeacherExample example) {
        return spTeacherMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String tId) {
        return spTeacherMapper.deleteByPrimaryKey(tId);
    }


    public int insert(SpTeacher record) {
        return spTeacherMapper.insert(record);
    }


    public int insertOrUpdate(SpTeacher record) {
        return spTeacherMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpTeacher record) {
        return spTeacherMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpTeacher record) {
        return spTeacherMapper.insertSelective(record);
    }


    public List<SpTeacher> selectByExample(SpTeacherExample example) {
        return spTeacherMapper.selectByExample(example);
    }


    public SpTeacher selectByPrimaryKey(String tId) {
        return spTeacherMapper.selectByPrimaryKey(tId);
    }


    public int updateByExampleSelective(SpTeacher record, SpTeacherExample example) {
        return spTeacherMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpTeacher record, SpTeacherExample example) {
        return spTeacherMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpTeacher record) {
        return spTeacherMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpTeacher record) {
        return spTeacherMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpTeacher> list) {
        return spTeacherMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpTeacher> list) {
        return spTeacherMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpTeacher> list) {
        return spTeacherMapper.batchInsert(list);
    }

}



