package com.example.usercrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoardResponse {


    private String title;

    private String content;

    private String username;

}
