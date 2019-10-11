package top.sunhu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: HelloController
 * @date: 2019/10/11 14:48
 * @author: SunHu
 */
@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(@RequestParam(name = "name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
