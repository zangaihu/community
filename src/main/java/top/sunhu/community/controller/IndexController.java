package top.sunhu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: HelloController
 * @date: 2019/10/11 14:48
 * @author: SunHu
 */
@Controller
public class IndexController {

    @GetMapping()
    public String index(){
        return "index";
    }
}
