package net.idrok.Resumes.service.impl;

import net.idrok.Resumes.entity.User;
import net.idrok.Resumes.repository.UserRepository;
import net.idrok.Resumes.service.UserService;
import net.idrok.Resumes.service.dto.UserDTO;
import net.idrok.Resumes.service.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
//
//    @Override
//    public Page<User> getAll(Pageable pageable) {
//        return userRepository.findAll(pageable);
//    }
//
//    @Override
//    public List<User> getAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User getById(Long id) {
//        return userRepository.getById(id);
//    }
//
    @Override
    public UserDTO create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return new UserDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        }

    @Override
    public Boolean checkUsername(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public UserDTO getByUserName(String username) {
        return new UserDTO(userRepository.findByUserName(username));
    }

    ;
//
//    @Override
//    public User update(User user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public void delete(User user) {
//        userRepository.delete(user);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public User getCurrentUserEntity() {
//        return null;
//    }
//
//    @Override
//    public void changePassword(UserVM userVM) {
//
//    }
//
//    @Override
//    public UserDTO getCurrentUser() {
//        return null;
//    }
//
//    @Override
//    public Optional<User> getByLogin(String login) {
//        return Optional.empty();
//    }
//
//    @Override
//    public String getCurrentLogin() {
//        return null;
//    }
}
