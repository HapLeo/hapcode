package top.hapleow.hapcodeweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String coding(String tableName){

        hapCodeService.coding(tableName);
        return "SUCCESS";
    }
}
