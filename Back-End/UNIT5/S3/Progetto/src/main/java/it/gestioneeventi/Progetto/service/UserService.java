package it.gestioneeventi.Progetto.service;


import it.gestioneeventi.Progetto.Dto.UserDto;
import it.gestioneeventi.Progetto.entity.User;
import it.gestioneeventi.Progetto.enums.Role;
import it.gestioneeventi.Progetto.exception.NotFoundException;
import it.gestioneeventi.Progetto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.Utente_normale);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        return "User with id=" + user.getId() + " correctly saved";
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public User updateUser(int id, UserDto userDto){
        Optional<User> userOptional = getUserById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            return userRepository.save(user);

        }
        else{
            throw new NotFoundException("User with id=" + id + " not found");
        }
    }

    public String deleteUser(int id){
        Optional<User> userOptional = getUserById(id);

        if(userOptional.isPresent()){
            userRepository.deleteById(id);
            return "User with id=" + id + " correctly deleted";
        }
        else{
            throw new NotFoundException("User with id=" + id + " not found");
        }
    }

    public User getUserByEmail(String email){
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else{
            throw new NotFoundException("User with email=" + email + " not found");
        }


    }
}