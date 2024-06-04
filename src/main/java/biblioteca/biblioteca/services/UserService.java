package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.User;
import biblioteca.biblioteca.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; 
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userIsPresent = userRepository.findByEmail(user.getEmail());

        if (userIsPresent.isPresent()) {
            throw new IllegalStateException("User with email " + user.getEmail() + " already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean userExists = userRepository.existsById(id);

        if (!userExists) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }

        userRepository.deleteById(id);
    }

}
