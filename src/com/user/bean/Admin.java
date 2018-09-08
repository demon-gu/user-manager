package com.user.bean;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/8 9:29
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;
    /**
     * 0代表没有删除，1代表删除
     */
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
