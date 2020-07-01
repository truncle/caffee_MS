package team.bxbz.caffee.mapper;

import team.bxbz.caffee.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //删除用户
    int deleteByUserID(String userID);
    //插入用户
    int insert(User record);
    //查询用户
    User selectByUserID(String userID);
    //更新用户
    int updateByUserID(User record);
}
