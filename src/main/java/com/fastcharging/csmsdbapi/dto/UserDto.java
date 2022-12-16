package com.fastcharging.csmsdbapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String nik;
    private String full_name;
    private String address;
    private String email;
    private String phone_number;
    private String tag_id;
    private String fcm_token;

}
