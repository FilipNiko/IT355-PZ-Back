package com.metropolitan.it355pzback.repository;

/**
 * Projection for {@link com.metropolitan.it355pzback.data.entities.User}
 */
public interface UserInfoProjection {
    Integer getId();

    String getUsername();

    String getEmail();
}