package top.sunhu.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.sunhu.community.pojo.User;

/**
 * @description: UserMapper
 * @date: 2019/10/12 10:43
 * @author: SunHu
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT into USER (ACCOUNT_ID, NAME, TOKEN, GMT_CREATE, GMT_MODIFIED) " +
            "VALUES (#{accountId} ,#{name} ,#{token} ,#{gmtCreate} ,#{gmtModified} )")
    void insert(User user);

    @Select("select * from USER where TOKEN=#{token} ")
    User findByToken(@Param("token") String token);
}
