package org.py.web2020.db.dao;

import org.apache.ibatis.annotations.*;
import org.py.web2020.db.model.UOrder;

import java.util.List;

@Mapper
public interface UOrderDao {
    String TABLE = "u_order";

    @Select({"delete from ", TABLE, " where id=#{id}"})
    void deleteByPrimaryKey(Integer id);

    @Insert({"insert into ", TABLE, " values(",
                "null, #{uid}, #{title}, #{price}",
            ")"})
    int insert(UOrder record);

    @Select({"select * from ", TABLE, " where id=#{id}"})
    UOrder selectByPrimaryKey(Long id);

    @Update({"update ", TABLE, " set uid=#{uid}, title=#{title}, price=#{price}",
                " where id=#{id}"})
    int updateByPrimaryKeySelective(UOrder record);

    @Select({"select * from ", TABLE, " where uid=#{uid}"})
    @Results({
            @Result(column = "uid", property = "user",
                    one=@One(select = "org.py.web2020.db.dao.UserDao.selectByPrimaryKey"))
    })
    List<UOrder> findByUid(long uid);
}