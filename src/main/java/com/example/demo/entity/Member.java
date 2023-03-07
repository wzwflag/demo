package com.example.demo.entity;

import java.util.Objects;

public class Member extends BaseModel
{
    private Long id;
    private Long projectId;
    private Long userId;
    private String authorize;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
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
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(projectId, member.projectId) && Objects.equals(userId, member.userId) && Objects.equals(authorize, member.authorize) && Objects.equals(state, member.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, authorize, state);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", authorize='" + authorize + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
