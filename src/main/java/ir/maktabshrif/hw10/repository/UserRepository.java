package ir.maktabshrif.hw10.repository;

import ir.maktabshrif.hw10.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User>findUser(String username, String password);
}
