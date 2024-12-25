package ir.maktabshrif.hw10.service;

import ir.maktabshrif.hw10.dto.UserDTO;
import ir.maktabshrif.hw10.model.User;
import ir.maktabshrif.hw10.repository.UserRepository;
import ir.maktabshrif.hw10.repository.UserRepositoryImpl;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void signup(UserDTO userDTO) {
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
        userRepository.save(user);
//        if (userRepository.findUser(userDTO.getUsername(), userDTO.getPassword()).isPresent()) {
//            throw new IllegalArgumentException("Username Already exist!!");
//        }
    }

    @Override
    public Optional<UserDTO> login(String username, String password) {
        Optional<User> user = userRepository.findUser(username, password);
        UserDTO userDTO = UserDTO.builder()
                .username(user.get().getUsername())
                .password(user.get().getPassword())
                .build();
        return Optional.ofNullable(userDTO);
    }
}
