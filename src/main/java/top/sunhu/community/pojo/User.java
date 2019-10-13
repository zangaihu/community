package top.sunhu.community.pojo;

import lombok.Data;

/**
 * @description: User
 * @date: 2019/10/12 10:40
 * @author: SunHu
 */
@Data
public class User {

    private int id;
    private String accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatar_url;


}
