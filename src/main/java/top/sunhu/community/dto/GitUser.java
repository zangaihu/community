package top.sunhu.community.dto;

import lombok.Data;

/**
 * @description: GitUser
 * @date: 2019/10/11 18:44
 * @author: SunHu
 */
@Data
public class GitUser {

    private Long id;
    private String name;
    private String bio;
    private String avatar_url;

}
