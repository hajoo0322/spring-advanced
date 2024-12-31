package org.example.develop.service;


import org.example.develop.dto.LoginRequestDto;
import org.example.develop.dto.RequestUserDto;
import org.example.develop.dto.ResponseUserDto;

public interface UserService {
    ResponseUserDto addUser(RequestUserDto requestUser);

    Long getUserId(LoginRequestDto loginRequestDto);
}
