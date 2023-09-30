package com.samsam.bsl.user.dto;

import lombok.Getter;

@Getter
public class ResponseDTO {
    private boolean result;
    private String errormessage;
    private String username;
    private String nickName;
    
    public ResponseDTO(boolean result) {
        this.result = result;
    }

    public ResponseDTO(boolean result, String message) {
        this.result = result;
        this.errormessage = message;
    }

    public ResponseDTO(String username, String userNickName) {
        this.username = username;
        this.nickName = userNickName;
    }
}
