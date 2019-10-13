package top.sunhu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.sunhu.community.dto.QuestionDTO;
import top.sunhu.community.mapper.UserMapper;
import top.sunhu.community.pojo.User;
import top.sunhu.community.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {


        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            //遍历cookie，找到名为token的cookie
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //去数据库查询，如果有则是登录过的
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDTO> questionDTOList=questionService.list();
        model.addAttribute("questions",questionDTOList);


        return "index";
    }
}
