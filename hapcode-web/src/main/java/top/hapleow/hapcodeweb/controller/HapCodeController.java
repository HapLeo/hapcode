package top.hapleow.hapcodeweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.hapleow.hapcodeweb.service.IHapCodeService;

/**
 * @author wuyulin
 * @date 2020/9/16
 */
@RestController
@RequestMapping("/hapcode")
public class HapCodeController {

    @Autowired
    private IHapCodeService hapCodeService;


    @RequestMapping("/coding")
    @ResponseBody
    public String coding(@RequestParam("tableName") String tableName, @RequestParam("templateKey") String templateKey) {

        hapCodeService.coding(tableName,templateKey);
        return "SUCCESS";
    }

    @RequestMapping("/codingAll")
    @ResponseBody
    public String codingAll(@RequestParam("tableName") String tableName) {

        hapCodeService.codingAll(tableName);
        return "SUCCESS";
    }
}