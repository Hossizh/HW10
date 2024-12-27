package ir.maktabshrif.hw10.service;

import ir.maktabshrif.hw10.dto.UserDTO;
import ir.maktabshrif.hw10.model.User;

import java.util.Optional;

public interface UserService {
    void signup(UserDTO userDTO);
    Optional<UserDTO> login(String username, String password);
    Boolean isUserValid(String username);
}
