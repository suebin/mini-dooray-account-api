package com.nhnacademy.minidoorayaccountapi.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    @NotBlank
    private String memberId;
    @NotBlank
    private String password;
    @Email
    private String email;
    @NotBlank
    private String name;
}
