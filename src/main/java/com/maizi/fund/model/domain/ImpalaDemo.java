package com.maizi.fund.model.domain;

import java.util.Objects;

/**
 * @author cs
 * @version 1.0
 * @date 2019/10/14 3:19 下午
 */
public class ImpalaDemo {
    private String type;
    private String user_id;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpalaDemo that = (ImpalaDemo) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, user_id);
    }


    @Override
    public String toString() {
        return "ImpalaDemo{" +
                "type='" + type + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
