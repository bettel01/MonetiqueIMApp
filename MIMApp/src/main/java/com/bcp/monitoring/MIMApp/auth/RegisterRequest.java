package com.bcp.monitoring.MIMApp.auth;

import com.bcp.monitoring.MIMApp.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Integer tel;
    private Role role;
}
