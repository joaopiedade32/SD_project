package edu.ufp.inf.sd.project.server;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private int credits;
    private ArrayList<JobShopSessionRI> sessions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.credits = 1000; //start with 1000 credits
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

    public int getCredits() {
        return credits;
    }

    public ArrayList<JobShopSessionRI> getSessions() {
        return sessions;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSessions(ArrayList<JobShopSessionRI> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}