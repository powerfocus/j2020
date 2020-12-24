package org.py.web2020.db.dao;

import org.apache.ibatis.annotations.*;
import org.py.web2020.db.model.User;

import java.util.List;

@Mapper
public interface UserDao {
    String TABLE = "user";

    @Delete({"delete from ", TABLE, " where id=#{id}"})
    int deleteByPrimaryKey(Integer id);

    @Insert({"insert ", TABLE, " values(null, #{userName},", "#{userPassword})"})
    int insert(User record);

    @Select({"select * from ", TABLE, " where id=#{id}"})
    User selectByPrimaryKey(Integer id);

    @Update({"update ", TABLE, " set user_name=#{userName}, #{userPassword}"})
    int updateByPrimaryKey(User record);

    /**
     * 一对多映射
     * */
    @Select({"select * from ", TABLE, " where id=#{id}"})
    @Results({
            @Result(column = "id", property = "orders", many = @Many(select = "org.py.web2020.db.dao.UOrderDao.findByUid"))
    })
    List<User> findAndOrder(long id);
}