package com.scfsoft.controller;
import com.scfsoft.domain.SpSc;

import com.scfsoft.service.SpScService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_sc)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_sc")
public class SpScController {
/**
* 服务对象
*/
@Resource
private SpScService spScService;



}
