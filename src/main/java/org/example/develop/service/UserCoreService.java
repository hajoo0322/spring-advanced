package org.example.develop.service;

import org.example.develop.dto.LoginRequestDto;
import org.example.develop.dto.RequestUserDto;
import org.example.develop.dto.ResponseUserDto;
import org.example.develop.entity.UserEntity;
import org.example.develop.hash.PasswordEncoder;
import org.example.develop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCoreService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCoreService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseUserDto addUser(RequestUserDto requestUser) {
        String encode = passwordEncoder.encode(requestUser.getPassword());
        UserEntity userEntity = new UserEntity(requestUser.getName(), requestUser.getEmail(),encode);
        UserEntity save = userRepository.save(userEntity);
        return new ResponseUserDto(save);
    }

    @Override
    public Long getUserId(LoginRequestDto loginRequestDto) {
        UserEntity user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (passwordEncoder.matches(loginRequestDto.getPassword(),user.getPassword())) {
            return user.getId();
        } else {
            throw new RuntimeException();
        }
    }
}
