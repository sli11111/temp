package com.scfsoft.controller;
import com.scfsoft.domain.SpRecord;

import com.scfsoft.service.SpRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_record)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_record")
public class SpRecordController {
/**
* 服务对象
*/
@Resource
private SpRecordService spRecordService;



}
