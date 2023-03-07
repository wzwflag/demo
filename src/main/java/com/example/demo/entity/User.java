package com.example.demo.entity;

import java.util.Objects;

public class User extends BaseModel
{
    private Long id;
    private String name;
    private String psw;
    private Long phoneNumber;

    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(psw, user.psw) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(state, user.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, psw, phoneNumber, state);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", state='" + state + '\'' +
                '}';
    }
}
