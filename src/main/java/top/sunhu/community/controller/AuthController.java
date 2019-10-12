package top.sunhu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.sunhu.community.dto.AcessTokenDTO;
import top.sunhu.community.dto.GitUser;
import top.sunhu.community.provider.GitHubProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description: AuthController
 * @date: 2019/10/11 17:16
 * @author: SunHu
 */
@Controller
public class AuthController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpSession session, HttpServletRequest request) {

        System.out.println(code);
        AcessTokenDTO acessTokenDTO = new AcessTokenDTO();
        acessTokenDTO.setClient_id("ce90307bcd867bf66e7a");
        acessTokenDTO.setClient_secret("565fd32484a4374ba29ef2ebc8bf455e5c95a6c4");
        acessTokenDTO.setCode(code);
        acessTokenDTO.setState(state);
        acessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        String accessToken = gitHubProvider.getAccessToken(acessTokenDTO);
        GitUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            return "redirect:/";
        }

    }


}
