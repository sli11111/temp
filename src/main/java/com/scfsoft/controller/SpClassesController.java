package com.scfsoft.controller;
import com.scfsoft.domain.SpClasses;

import com.scfsoft.service.SpClassesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_classes)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_classes")
public class SpClassesController {
/**
* 服务对象
*/
@Resource
private SpClassesService spClassesService;



}
