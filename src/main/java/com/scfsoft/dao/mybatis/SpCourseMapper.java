package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpCourse;
import com.scfsoft.domain.SpCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpCourseMapper {
    long countByExample(SpCourseExample example);

    int deleteByExample(SpCourseExample example);

    /**
     * delete by primary key
     *
     * @param cId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String cId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpCourse record);

    int insertOrUpdate(SpCourse record);

    int insertOrUpdateSelective(SpCourse record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpCourse record);

    List<SpCourse> selectByExample(SpCourseExample example);

    /**
     * select by primary key
     *
     * @param cId primary key
     * @return object by primary key
     */
    SpCourse selectByPrimaryKey(String cId);

    int updateByExampleSelective(@Param("record") SpCourse record, @Param("example") SpCourseExample example);

    int updateByExample(@Param("record") SpCourse record, @Param("example") SpCourseExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpCourse record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpCourse record);

    int updateBatch(List<SpCourse> list);

    int updateBatchSelective(List<SpCourse> list);

    int batchInsert(@Param("list") List<SpCourse> list);
}