package com.scfsoft.controller;
import com.scfsoft.domain.SpCtc;

import com.scfsoft.service.SpCtcService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_ctc)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_ctc")
public class SpCtcController {
/**
* 服务对象
*/
@Resource
private SpCtcService spCtcService;



}
