package com.example.wgmanager.Model;

public class User {

    //TODO: Group, Event etc einfügen
    private int id;
    private String email;
    private String username;
    private String password;
    private Group group;

    public User(String username, String password, String groupName) {
        this.email = email;
        this.username = username;
        this.password = password;
        group = new Group(groupName, this);

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.group = null;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
