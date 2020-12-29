package com.cnleng.api.response;

public class UserResponse extends ApiResponse {

    private Long userId;
    private String name;
    private String email;

    public UserResponse() {
        super();
    }

    public UserResponse(String message, Exception error) {
        super(message, error);
    }

    public UserResponse(String message, Long userId, String name, String email) {
        super(message);
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
