package top.sunhu.community.dto;

import lombok.Data;
import top.sunhu.community.pojo.User;

/**
 * @description: QusetionDTO
 * @date: 2019/10/13 14:53
 * @author: SunHu
 */
@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String  tag;
    private User user;
}
