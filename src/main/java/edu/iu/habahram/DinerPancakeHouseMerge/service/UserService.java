package edu.iu.habahram.DinerPancakeHouseMerge.service;

import edu.iu.habahram.DinerPancakeHouseMerge.repository.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String username, String password, String email)
            throws BadRequestException {
        if (username == null || password == null || email == null) {
            throw new BadRequestException("All fields are required");
        }
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            throw new BadRequestException("All fields are required");
        }
        userRepository.save(username, password, email);
    }
}
