package top.sunhu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.sunhu.community.dto.AcessTokenDTO;
import top.sunhu.community.dto.GitUser;
import top.sunhu.community.mapper.UserMapper;
import top.sunhu.community.pojo.User;
import top.sunhu.community.provider.GitHubProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @description: AuthController
 * @date: 2019/10/11 17:16
 * @author: SunHu
 */
@Controller
public class AuthController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpSession session, HttpServletResponse response) {

        System.out.println(code);
        AcessTokenDTO acessTokenDTO = new AcessTokenDTO();
        acessTokenDTO.setClient_id("ce90307bcd867bf66e7a");
        acessTokenDTO.setClient_secret("565fd32484a4374ba29ef2ebc8bf455e5c95a6c4");
        acessTokenDTO.setCode(code);
        acessTokenDTO.setState(state);
        acessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        String accessToken = gitHubProvider.getAccessToken(acessTokenDTO);
        GitUser gitUser = gitHubProvider.getUser(accessToken);
        System.out.println(gitUser.getName());

        if (gitUser != null && gitUser.getId() != null) {
            User user = new User();
            user.setAccountId(String.valueOf(gitUser.getId()));
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(gitUser.getName());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(gitUser.getAvatar_url());

            userMapper.insert(user);
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            return "redirect:/";
        }

    }


}
