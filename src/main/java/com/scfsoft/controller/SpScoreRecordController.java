package com.scfsoft.controller;
import com.scfsoft.domain.SpScoreRecord;

import com.scfsoft.service.SpScoreRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_score_record)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_score_record")
public class SpScoreRecordController {
/**
* 服务对象
*/
@Resource
private SpScoreRecordService spScoreRecordService;



}
