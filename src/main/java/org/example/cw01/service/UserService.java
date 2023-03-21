package org.example.cw01.service;

import org.example.cw01.model.User;

public interface UserService {
    void save(User user);

    boolean credit(User user, int creditSum);
}
