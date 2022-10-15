package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.scfsoft.dao.mybatis.SpCtcMapper;
import java.util.List;
import com.scfsoft.domain.SpCtc;
import com.scfsoft.domain.SpCtcExample;

@Service
public class SpCtcService {

    @Resource
    private SpCtcMapper spCtcMapper;


    public long countByExample(SpCtcExample example) {
        return spCtcMapper.countByExample(example);
    }


    public int deleteByExample(SpCtcExample example) {
        return spCtcMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String ctcClassid, String ctcTeacherid, String ctcCourseid, Integer ctcXueqi) {
        return spCtcMapper.deleteByPrimaryKey(ctcClassid, ctcTeacherid, ctcCourseid, ctcXueqi);
    }


    public int insert(SpCtc record) {
        return spCtcMapper.insert(record);
    }


    public int insertOrUpdate(SpCtc record) {
        return spCtcMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpCtc record) {
        return spCtcMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpCtc record) {
        return spCtcMapper.insertSelective(record);
    }


    public List<SpCtc> selectByExample(SpCtcExample example) {
        return spCtcMapper.selectByExample(example);
    }


    public int updateByExampleSelective(SpCtc record, SpCtcExample example) {
        return spCtcMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpCtc record, SpCtcExample example) {
        return spCtcMapper.updateByExample(record, example);
    }


    public int updateBatch(List<SpCtc> list) {
        return spCtcMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpCtc> list) {
        return spCtcMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpCtc> list) {
        return spCtcMapper.batchInsert(list);
    }

}



