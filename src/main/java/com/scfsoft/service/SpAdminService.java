package com.scfsoft.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.scfsoft.domain.SpAdmin;
import com.scfsoft.domain.SpAdminExample;
import com.scfsoft.dao.mybatis.SpAdminMapper;

@Service
public class SpAdminService {

    @Resource
    private SpAdminMapper spAdminMapper;


    public long countByExample(SpAdminExample example) {
        return spAdminMapper.countByExample(example);
    }


    public int deleteByExample(SpAdminExample example) {
        return spAdminMapper.deleteByExample(example);
    }


    public int deleteByPrimaryKey(String adminId) {
        return spAdminMapper.deleteByPrimaryKey(adminId);
    }


    public int insert(SpAdmin record) {
        return spAdminMapper.insert(record);
    }


    public int insertOrUpdate(SpAdmin record) {
        return spAdminMapper.insertOrUpdate(record);
    }


    public int insertOrUpdateSelective(SpAdmin record) {
        return spAdminMapper.insertOrUpdateSelective(record);
    }


    public int insertSelective(SpAdmin record) {
        return spAdminMapper.insertSelective(record);
    }


    public List<SpAdmin> selectByExample(SpAdminExample example) {
        return spAdminMapper.selectByExample(example);
    }


    public SpAdmin selectByPrimaryKey(String adminId) {
        return spAdminMapper.selectByPrimaryKey(adminId);
    }


    public int updateByExampleSelective(SpAdmin record, SpAdminExample example) {
        return spAdminMapper.updateByExampleSelective(record, example);
    }


    public int updateByExample(SpAdmin record, SpAdminExample example) {
        return spAdminMapper.updateByExample(record, example);
    }


    public int updateByPrimaryKeySelective(SpAdmin record) {
        return spAdminMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SpAdmin record) {
        return spAdminMapper.updateByPrimaryKey(record);
    }


    public int updateBatch(List<SpAdmin> list) {
        return spAdminMapper.updateBatch(list);
    }


    public int updateBatchSelective(List<SpAdmin> list) {
        return spAdminMapper.updateBatchSelective(list);
    }


    public int batchInsert(List<SpAdmin> list) {
        return spAdminMapper.batchInsert(list);
    }

}

