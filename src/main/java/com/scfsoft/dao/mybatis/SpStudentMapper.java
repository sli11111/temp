package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpStudent;
import com.scfsoft.domain.SpStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpStudentMapper {
    long countByExample(SpStudentExample example);

    int deleteByExample(SpStudentExample example);

    /**
     * delete by primary key
     *
     * @param sId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer sId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpStudent record);

    int insertOrUpdate(SpStudent record);

    int insertOrUpdateSelective(SpStudent record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpStudent record);

    List<SpStudent> selectByExample(SpStudentExample example);

    /**
     * select by primary key
     *
     * @param sId primary key
     * @return object by primary key
     */
    SpStudent selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") SpStudent record, @Param("example") SpStudentExample example);

    int updateByExample(@Param("record") SpStudent record, @Param("example") SpStudentExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpStudent record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpStudent record);

    int updateBatch(List<SpStudent> list);

    int updateBatchSelective(List<SpStudent> list);

    int batchInsert(@Param("list") List<SpStudent> list);
}