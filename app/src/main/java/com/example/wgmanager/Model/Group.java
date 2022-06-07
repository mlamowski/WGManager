package com.example.wgmanager.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Group {

    String groupName;
    public ArrayList <User> member = new ArrayList<User>();

    public Group(String groupName, User user) {
        this.groupName = groupName;
        this.member.add(user);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<User> getMember() {
        return member;
    }

    public void setMember(ArrayList<User> member) {
        this.member = member;
    }
}
