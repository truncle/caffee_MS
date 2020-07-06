package team.bxbz.caffee.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.bxbz.caffee.entity.Administrator;

//管理员可以修改管理员的信息并且可以增加、删除、修改用户
@Mapper
public interface AdminMapper {
    //删除管理员
    int deleteByAdminID(String ad_ID);

    //插入管理员
    int insert(Administrator record);

    //查询管理员
    Administrator selectByAdminID(String ad_ID);

    //更新用户信息
    int updateByAdminID(Administrator record);
}
