package org.py.web2020.web.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserModel implements Serializable {
    private Long id;
    @NotEmpty(message = "必须填写用户名")
    private String username;
    @NotEmpty(message = "必须填写密码")
    private String pwd;

    public UserModel() {
    }

    public UserModel(Long id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
