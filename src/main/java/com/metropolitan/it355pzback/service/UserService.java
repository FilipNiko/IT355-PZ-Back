package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.repository.UserInfoProjection;

import java.util.Optional;

public interface UserService {

    Optional<UserInfoProjection> findProjectionById(Integer id);
}
