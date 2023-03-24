//package com.example.applemanagement.service.login;
//
//import com.example.applemanagement.repository.login.IRoleRepository;
//import com.example.applemanagement.repository.login.IUserRepository;
//import com.example.applemanagement.dto.login.LoginDTO;
////import com.example.applemanagement.dto.login.RegisterDTO;
////import com.example.applemanagement.exception.UserAPIException;
//import com.example.applemanagement.model.login.Role;
//import com.example.applemanagement.model.login.User;
////import com.example.applemanagement.security.JwtTokenProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class AuthService implements IAuthService{
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private IUserRepository userRepository;
//    @Autowired
//    private IRoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//
//    @Override
//    public String login(LoginDTO loginDto) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = jwtTokenProvider.generateToken(authentication);
//
//        return token;
//    }
//
//    @Override
//    public String register(RegisterDTO registerDto) {
//
//        // add check for username exists in database
//        if(userRepository.existsByUsername(registerDto.getUsername())){
//            throw new UserAPIException(HttpStatus.BAD_REQUEST, "Ten dang nhap da ton tai!.");
//        }
//
//        // add check for email exists in database
//        if(userRepository.existsByEmail(registerDto.getEmail())){
//            throw new UserAPIException(HttpStatus.BAD_REQUEST, "Email da ton tai!.");
//        }
//
//        User user = new User();
//        user.setName(registerDto.getName());
//        user.setUsername(registerDto.getUsername());
//        user.setEmail(registerDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        Role userRole = roleRepository.findByName("ROLE_USER").get();
//        roles.add(userRole);
//        user.setRoleSet(roles);
//
//        userRepository.save(user);
//
//        return "Dang nhap thanh cong!.";
//    }
//}
