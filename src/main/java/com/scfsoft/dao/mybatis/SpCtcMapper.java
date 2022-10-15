package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpCtc;
import com.scfsoft.domain.SpCtcExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpCtcMapper {
    long countByExample(SpCtcExample example);

    int deleteByExample(SpCtcExample example);

    /**
     * delete by primary key
     *
     * @param ctcClassid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("ctcClassid") String ctcClassid, @Param("ctcTeacherid") String ctcTeacherid, @Param("ctcCourseid") String ctcCourseid, @Param("ctcXueqi") Integer ctcXueqi);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpCtc record);

    int insertOrUpdate(SpCtc record);

    int insertOrUpdateSelective(SpCtc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpCtc record);

    List<SpCtc> selectByExample(SpCtcExample example);

    int updateByExampleSelective(@Param("record") SpCtc record, @Param("example") SpCtcExample example);

    int updateByExample(@Param("record") SpCtc record, @Param("example") SpCtcExample example);

    int updateBatch(List<SpCtc> list);

    int updateBatchSelective(List<SpCtc> list);

    int batchInsert(@Param("list") List<SpCtc> list);
}