package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> users = new ArrayList<>();

    public Forum(){
        users.add(new ForumUser(1, "Aaa",'M', LocalDate.of(2010,12,1),100));
        users.add(new ForumUser(1, "Bbb",'F', LocalDate.of(1990,11,2),200));
        users.add(new ForumUser(1, "Ccc",'M', LocalDate.of(1980,10,2),0));
        users.add(new ForumUser(1, "Ddd",'F', LocalDate.of(1970,9,4),10));
        users.add(new ForumUser(1, "Eee",'M', LocalDate.of(1960,8,5),500));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(users);
    }
}
