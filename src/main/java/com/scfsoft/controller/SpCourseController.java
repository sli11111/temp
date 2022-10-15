package com.scfsoft.controller;
import com.scfsoft.domain.SpCourse;

import com.scfsoft.service.SpCourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_course)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_course")
public class SpCourseController {
/**
* 服务对象
*/
@Resource
private SpCourseService spCourseService;



}
