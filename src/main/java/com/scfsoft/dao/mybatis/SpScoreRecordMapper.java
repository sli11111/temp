package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpScoreRecord;
import com.scfsoft.domain.SpScoreRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpScoreRecordMapper {
    long countByExample(SpScoreRecordExample example);

    int deleteByExample(SpScoreRecordExample example);

    /**
     * delete by primary key
     *
     * @param srStuid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("srStuid") Integer srStuid, @Param("srCourseid") String srCourseid, @Param("srExamtime") String srExamtime);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpScoreRecord record);

    int insertOrUpdate(SpScoreRecord record);

    int insertOrUpdateSelective(SpScoreRecord record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpScoreRecord record);

    List<SpScoreRecord> selectByExample(SpScoreRecordExample example);

    /**
     * select by primary key
     *
     * @param srStuid primary key
     * @return object by primary key
     */
    SpScoreRecord selectByPrimaryKey(@Param("srStuid") Integer srStuid, @Param("srCourseid") String srCourseid, @Param("srExamtime") String srExamtime);

    int updateByExampleSelective(@Param("record") SpScoreRecord record, @Param("example") SpScoreRecordExample example);

    int updateByExample(@Param("record") SpScoreRecord record, @Param("example") SpScoreRecordExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SpScoreRecord record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SpScoreRecord record);

    int updateBatch(List<SpScoreRecord> list);

    int updateBatchSelective(List<SpScoreRecord> list);

    int batchInsert(@Param("list") List<SpScoreRecord> list);
}