package it.progetto.Progetto.controller;


import it.progetto.Progetto.Dto.DipendenteDto;
import it.progetto.Progetto.Dto.DipendenteLoginDto;
import it.progetto.Progetto.exception.BadRequestException;
import it.progetto.Progetto.service.AuthService;
import it.progetto.Progetto.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/auth/register")
    public String register(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult){ //
        if(bindingResult.hasErrors()){
            throw new it.progetto.Progetto.exception.BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated DipendenteLoginDto dipendenteLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(error->error.getDefaultMessage()).reduce("",(s, s2) -> s+s2));
        }
        return authService.authenticateDipendenteAndCreateToken(dipendenteLoginDto);
    }
}
