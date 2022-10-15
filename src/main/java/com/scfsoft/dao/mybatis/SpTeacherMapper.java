package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpTeacher;
import com.scfsoft.domain.SpTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpTeacherMapper {
    long countByExample(SpTeacherExample example);

    int deleteByExample(SpTeacherExample example);

    /**
     * delete by primary key
     *
     * @param tId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String tId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpTeacher record);

    int insertOrUpdate(SpTeacher record);

    int insertOrUpdateSelective(SpTeacher record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpTeacher record);

    List<SpTeacher> selectByExample(SpTeacherExample example);

    /**
     * select by primary key
     *
     * @param tId primary key
     * @return object by primary key
     */
    SpTeacher selectByPrimaryKey(String tId);

    int updateByExampleSelective(@Param("record") SpTeacher record, @Param("example") SpTeacherExample example);

    int updateByExample(@Param("record") SpTeacher record, @Param("example") SpTeacherExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpTeacher record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpTeacher record);

    int updateBatch(List<SpTeacher> list);

    int updateBatchSelective(List<SpTeacher> list);

    int batchInsert(@Param("list") List<SpTeacher> list);
}