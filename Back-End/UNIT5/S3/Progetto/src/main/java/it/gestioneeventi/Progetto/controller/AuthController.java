package it.gestioneeventi.Progetto.controller;


import it.gestioneeventi.Progetto.Dto.UserDto;
import it.gestioneeventi.Progetto.Dto.UserLoginDto;
import it.gestioneeventi.Progetto.exception.BadRequestException;
import it.gestioneeventi.Progetto.service.AuthService;
import it.gestioneeventi.Progetto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @PostMapping("/auth/register")
    public String register(@RequestBody @Validated UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }

        return userService.saveUser(userDto);
    }
    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated UserLoginDto userLoginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).
                    reduce("", (s, s2) -> s+s2));
        }

        return authService.authenticateUserAndCreateToken(userLoginDto);
    }
}
