package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    final private int id;
    final private String userName;
    final private char sex;
    final private LocalDate dateOfBirth;
    final private int postsNumber;

    public ForumUser(final int id, final String userName, final char sex, final LocalDate dateOfBirth, final int postsNumber) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postsNumber = postsNumber;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsNumber=" + postsNumber +
                '}';
    }
}
