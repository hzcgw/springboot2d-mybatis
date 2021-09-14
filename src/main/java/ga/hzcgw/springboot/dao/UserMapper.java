package ga.hzcgw.springboot.dao;

import ga.hzcgw.springboot.po.User;
import ga.hzcgw.springboot.query.UserQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tb_user(id, user_name, user_pwd)" +
            "values(#{id,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, #{userPwd,jdbcType=VARCHAR})")
    int addUser(User user);

    @Delete("delete from tb_user where id = #{id}")
    int deleteUserById(Integer id);

    @Update("update tb_user set user_name = #{userName}, user_pwd = #{userPwd} where id = #{id}")
    int updateUser(User user);

    @Select("select * from tb_user where user_name = #{userName}")
    User queryUserByUserName(String userName);

    @Select("select * from tb_user where id = #{id}")
    User queryUserById(Integer id);

    @Select("select * from tb_user")
    List<User> queryUserAll();

    @Select("select * from tb_user where user_name like concat('%', #{userName}, '%')")
    List<User> queryUserByParams(UserQuery userQuery);

}
