package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpRecord;
import com.scfsoft.domain.SpRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpRecordMapper {
    long countByExample(SpRecordExample example);

    int deleteByExample(SpRecordExample example);

    /**
     * delete by primary key
     *
     * @param categorys primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String categorys);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpRecord record);

    int insertOrUpdate(SpRecord record);

    int insertOrUpdateSelective(SpRecord record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpRecord record);

    List<SpRecord> selectByExample(SpRecordExample example);

    /**
     * select by primary key
     *
     * @param categorys primary key
     * @return object by primary key
     */
    SpRecord selectByPrimaryKey(String categorys);

    int updateByExampleSelective(@Param("record") SpRecord record, @Param("example") SpRecordExample example);

    int updateByExample(@Param("record") SpRecord record, @Param("example") SpRecordExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpRecord record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpRecord record);

    int updateBatch(List<SpRecord> list);

    int updateBatchSelective(List<SpRecord> list);

    int batchInsert(@Param("list") List<SpRecord> list);
}