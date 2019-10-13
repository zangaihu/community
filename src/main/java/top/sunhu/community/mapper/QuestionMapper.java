package top.sunhu.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import top.sunhu.community.pojo.Question;

/**
 * @description: QuestionMapper
 * @date: 2019/10/13 11:42
 * @author: SunHu
 */

@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION(title, description, gmt_create, gmt_modified, creator, tag) " +
            "VALUES ( #{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void createQuestion(Question question);
}
