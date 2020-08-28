package top.hapleow.hapcodeweb.controller;

import top.hapleow.hapcodeweb.service.ITableFieldService;
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
@RequestMapping("/table")
public class TableController {

    @Autowired
    private ITableFieldService tableFieldsService;


    @RequestMapping("/fields")
    public Object tableFields(@RequestParam String tableName) {
        return tableFieldsService.getTableFields(tableName);
    }
}
