package com.metropolitan.it355pzback.service.impl;

import com.metropolitan.it355pzback.repository.UserInfoProjection;
import com.metropolitan.it355pzback.repository.UserRepository;
import com.metropolitan.it355pzback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Optional<UserInfoProjection> findProjectionById(Integer id) {
        return userRepository.findUserProjectionById(id);
    }
}
