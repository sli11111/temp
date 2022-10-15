package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpClasses;
import com.scfsoft.domain.SpClassesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpClassesMapper {
    long countByExample(SpClassesExample example);

    int deleteByExample(SpClassesExample example);

    /**
     * delete by primary key
     *
     * @param csId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String csId);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpClasses record);

    int insertOrUpdate(SpClasses record);

    int insertOrUpdateSelective(SpClasses record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpClasses record);

    List<SpClasses> selectByExample(SpClassesExample example);

    /**
     * select by primary key
     *
     * @param csId primary key
     * @return object by primary key
     */
    SpClasses selectByPrimaryKey(String csId);

    int updateByExampleSelective(@Param("record") SpClasses record, @Param("example") SpClassesExample example);

    int updateByExample(@Param("record") SpClasses record, @Param("example") SpClassesExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpClasses record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpClasses record);

    int updateBatch(List<SpClasses> list);

    int updateBatchSelective(List<SpClasses> list);

    int batchInsert(@Param("list") List<SpClasses> list);
}