package com.scfsoft.controller;
import com.scfsoft.domain.SpStudent;

import com.scfsoft.service.SpStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_student)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_student")
public class SpStudentController {
/**
* 服务对象
*/
@Resource
private SpStudentService spStudentService;



}
