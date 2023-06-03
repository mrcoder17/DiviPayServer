
package ru.nsu.boxberger.DiviPay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationRequest {

    @JsonProperty ("userID")
    private Long userID;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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
}
