package top.sunhu.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import top.sunhu.community.dto.AcessTokenDTO;
import top.sunhu.community.dto.GitUser;


import java.io.IOException;

/**
 * @description: GitHubProvider
 * @date: 2019/10/11 17:13
 * @author: SunHu
 */
@Component
public class GitHubProvider {

    public String getAccessToken(AcessTokenDTO acessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(acessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();

            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    public GitUser getUser(String accessToken) {
        System.out.println("https://api.github.com/user?" + accessToken);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GitUser gitUser = JSON.parseObject(string, GitUser.class);

            return gitUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
