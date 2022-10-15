package com.scfsoft.controller;
import com.scfsoft.domain.SpAdmin;
import com.scfsoft.service.SpAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (sp_admin)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/sp_admin")
public class SpAdminController {
    /**
     * 服务对象
     */
    @Resource
    private SpAdminService spAdminService;

/**
 * 通过主键查询单条数据
 *
 * @param id 主键
 * @return 单条数据
 */
}