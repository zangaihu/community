package top.sunhu.community.pojo;

import lombok.Data;

/**
 * @description: Question
 * @date: 2019/10/13 11:44
 * @author: SunHu
 */
@Data
public class Question {

    private int id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String  tag;

}
