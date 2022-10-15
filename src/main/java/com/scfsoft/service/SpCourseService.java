package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.scfsoft.dao.mybatis.SpCourseMapper;
import java.util.List;
import com.scfsoft.domain.SpCourse;
import com.scfsoft.domain.SpCourseExample;

@Service
public class SpCourseService {

    @Resource
    private SpCourseMapper spCourseMapper;


    public long countByExample(SpCourseExample example) {
        return spCourseMapper.countByExample(example);
    }


    public int deleteByExample(SpCourseExample example) {
        return spCourseMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String cId) {
        return spCourseMapper.deleteByPrimaryKey(cId);
    }


    public int insert(SpCourse record) {
        return spCourseMapper.insert(record);
    }


    public int insertOrUpdate(SpCourse record) {
        return spCourseMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpCourse record) {
        return spCourseMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpCourse record) {
        return spCourseMapper.insertSelective(record);
    }


    public List<SpCourse> selectByExample(SpCourseExample example) {
        return spCourseMapper.selectByExample(example);
    }


    public SpCourse selectByPrimaryKey(String cId) {
        return spCourseMapper.selectByPrimaryKey(cId);
    }


    public int updateByExampleSelective(SpCourse record, SpCourseExample example) {
        return spCourseMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpCourse record, SpCourseExample example) {
        return spCourseMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpCourse record) {
        return spCourseMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpCourse record) {
        return spCourseMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpCourse> list) {
        return spCourseMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpCourse> list) {
        return spCourseMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpCourse> list) {
        return spCourseMapper.batchInsert(list);
    }

}



