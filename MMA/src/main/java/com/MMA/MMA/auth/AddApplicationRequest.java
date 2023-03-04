package com.MMA.MMA.auth;

import com.MMA.MMA.Entites.Statues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddApplicationRequest {



    private String client;

    private String project;

    private String roleid;
    private Statues statues;
    private String title;
}
