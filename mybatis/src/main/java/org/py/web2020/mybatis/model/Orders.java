package org.py.web2020.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("orders")
public class Orders {
    @TableId
    private Long id;
    private Long uid;
    private String title;

    public Orders() {
    }

    public Orders(Long id, Long uid, String title) {
        this.id = id;
        this.uid = uid;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                '}';
    }
}
