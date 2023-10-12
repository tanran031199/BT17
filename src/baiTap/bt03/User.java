package baiTap.bt03;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name, password;
    private boolean status;

    public User() {
    }

    public User(int id, String name, String password, boolean status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
    }
}
