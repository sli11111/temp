package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpAdmin;
import com.scfsoft.domain.SpAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpAdminMapper {
    long countByExample(SpAdminExample example);

    int deleteByExample(SpAdminExample example);

    /**
     * delete by primary key
     *
     * @param adminId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String adminId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpAdmin record);

    int insertOrUpdate(SpAdmin record);

    int insertOrUpdateSelective(SpAdmin record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpAdmin record);

    List<SpAdmin> selectByExample(SpAdminExample example);

    /**
     * select by primary key
     *
     * @param adminId primary key
     * @return object by primary key
     */
    SpAdmin selectByPrimaryKey(String adminId);

    int updateByExampleSelective(@Param("record") SpAdmin record, @Param("example") SpAdminExample example);

    int updateByExample(@Param("record") SpAdmin record, @Param("example") SpAdminExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpAdmin record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpAdmin record);

    int updateBatch(List<SpAdmin> list);

    int updateBatchSelective(List<SpAdmin> list);

    int batchInsert(@Param("list") List<SpAdmin> list);
}