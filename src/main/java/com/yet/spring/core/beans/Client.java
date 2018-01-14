package com.yet.spring.core.beans;

public class Client {
    private String id;
    private String fullName;
    private String gr;


    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }


    public void setGreeting(String gr) {
        this.gr = gr;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {

        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
