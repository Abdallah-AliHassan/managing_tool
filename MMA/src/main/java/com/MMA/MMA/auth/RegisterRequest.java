package com.MMA.MMA.auth;

import com.MMA.MMA.Entites.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private Integer level;
    private String email;
    private String password;
    private String onbenchsince;
    private Role role;
}
