package com.example.wgmanager.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Group {

    String groupName;
    ArrayList <User> member = new ArrayList<User>();

    public Group(String groupName, User user) {
        this.groupName = groupName;
        this.member.add(user);

    }
}
