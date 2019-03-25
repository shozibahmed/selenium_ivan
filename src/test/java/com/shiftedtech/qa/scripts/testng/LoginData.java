package com.shiftedtech.qa.scripts.testng;

/**
 * Created by ShiftTeacher on 2/11/2018.
 */
public class LoginData {

    private String id;
    private String description;
    private boolean skiped;

    private String email;
    private String password;

    public LoginData(){
    }

    public LoginData(String id, String description, String email, String password) {
        this.id = id;
        this.description = description;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSkiped() {
        return skiped;
    }

    public void setSkiped(boolean skiped) {
        this.skiped = skiped;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
