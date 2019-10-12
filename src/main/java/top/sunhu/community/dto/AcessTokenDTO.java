package top.sunhu.community.dto;

import lombok.Data;

/**
 * @description: AcessTokenDTO
 * @date: 2019/10/11 17:06
 * @author: SunHu
 */
@Data
public class AcessTokenDTO {
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String code;
    private String state;
}
