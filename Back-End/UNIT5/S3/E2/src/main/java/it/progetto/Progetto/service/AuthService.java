package it.progetto.Progetto.service;


import it.progetto.Progetto.Dto.DipendenteLoginDto;
import it.progetto.Progetto.exception.UnauthorizedException;
import it.progetto.Progetto.model.Dipendente;
import it.progetto.Progetto.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private DipendenteService dipendenteService;


    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateDipendenteAndCreateToken(DipendenteLoginDto dipendenteLoginDto){
        Dipendente dipendente = dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());

        if(passwordEncoder.matches(dipendenteLoginDto.getPassword(),dipendente.getPassword())){
            return jwtTool.createToken(dipendente);
        } else{
            throw new UnauthorizedException("Error in authorization,relogin!");
        }
    }
}
