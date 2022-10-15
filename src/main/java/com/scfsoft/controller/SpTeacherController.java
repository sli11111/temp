package com.scfsoft.controller;
import com.scfsoft.domain.SpTeacher;

import com.scfsoft.service.SpTeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_teacher)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_teacher")
public class SpTeacherController {
/**
* 服务对象
*/
@Resource
private SpTeacherService spTeacherService;



}
