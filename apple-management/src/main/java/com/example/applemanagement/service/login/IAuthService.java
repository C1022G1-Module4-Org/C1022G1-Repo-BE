package com.example.applemanagement.service.login;

import com.example.applemanagement.dto.login.LoginDTO;
import com.example.applemanagement.dto.login.RegisterDTO;

public interface IAuthService {
    String login(LoginDTO loginDto);

    String register(RegisterDTO registerDto);
}
