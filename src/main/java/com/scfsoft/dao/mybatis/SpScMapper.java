package com.scfsoft.dao.mybatis;

import com.scfsoft.domain.SpSc;
import com.scfsoft.domain.SpScExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpScMapper {
    long countByExample(SpScExample example);

    int deleteByExample(SpScExample example);

    /**
     * delete by primary key
     *
     * @param scClassid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("scClassid") String scClassid, @Param("scStuid") Integer scStuid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SpSc record);

    int insertOrUpdate(SpSc record);

    int insertOrUpdateSelective(SpSc record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SpSc record);

    List<SpSc> selectByExample(SpScExample example);

    int updateByExampleSelective(@Param("record") SpSc record, @Param("example") SpScExample example);

    int updateByExample(@Param("record") SpSc record, @Param("example") SpScExample example);

    int updateBatch(List<SpSc> list);

    int updateBatchSelective(List<SpSc> list);

    int batchInsert(@Param("list") List<SpSc> list);
}