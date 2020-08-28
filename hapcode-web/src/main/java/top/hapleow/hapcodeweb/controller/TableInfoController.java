package top.hapleow.hapcodeweb.controller;

import top.hapleow.hapcodeweb.service.ITableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wuyulin
 * @date 2020/8/28
 */
@Controller
@ResponseBody
@RequestMapping("/tableInfo")
public class TableInfoController {

    @Autowired
    private ITableInfoService tableInfoService;

    @RequestMapping("/tables")
    public Object tables() {
        return tableInfoService.getTables();
    }


    @RequestMapping("/fields")
    public Object tableFields(@RequestParam String tableName) {
        return tableInfoService.getTableFields(tableName);
    }
}
