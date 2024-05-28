package it.progetto.Progetto.service;


import com.cloudinary.Cloudinary;
import it.progetto.Progetto.Dto.DipendenteDto;
import it.progetto.Progetto.exception.DipendenteNonTrovatoException;
import it.progetto.Progetto.model.Dipendente;
import it.progetto.Progetto.model.Role;
import it.progetto.Progetto.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveDipendente(DipendenteDto dipendenteDto){
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendente.setRole(Role.USER);
        dipendente.setPassword(passwordEncoder.encode(dipendenteDto.getPassword()));
        sendMail(dipendente.getEmail(),dipendente.getNome(),dipendente.getUsername());
       dipendenteRepository.save(dipendente);
       return "Dipendente con id = " + dipendente.getId() + "salvato correttamente";

    }


    public List<Dipendente> getAllDipendenti(){
        return dipendenteRepository.findAll();
    }
    public Optional<Dipendente> getDipendenteById(int id){
        return dipendenteRepository.findById(id);
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }


    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto){
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            Dipendente dipendente= dipendenteOptional.get();
             dipendente.setUsername(dipendenteDto.getUsername());
             dipendente.setNome(dipendenteDto.getNome());
             dipendente.setCognome(dipendenteDto.getCognome());
             dipendente.setEmail(dipendenteDto.getEmail());
             dipendente.setPassword(passwordEncoder.encode(dipendenteDto.getPassword()));
             dipendenteRepository.save(dipendente);
             return dipendente;

        } else{
            throw new DipendenteNonTrovatoException("Dipendente con id = " +id+ "non trovato");
        }

    }

    public String deleteDipendente(int id){
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if(dipendenteOptional.isPresent()){
            Dipendente dipendente = dipendenteOptional.get();
            dipendenteRepository.delete(dipendente);
            return "Dipendente con id = " + id + " cancellato con successo";
        } else{
            throw new DipendenteNonTrovatoException("Dipendente con id = " + id + " non trovato");
        }
    }



    public String patchFotoDipendente(int id, MultipartFile foto) throws IOException {
        Optional<Dipendente> dipenenteOpt = getDipendenteById(id);
        if (dipenenteOpt.isPresent()) {
            String url = (String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipenenteOpt.get();
            dipendente.setFoto(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente con matricola = " + id + "aggiornato correttamente con la foto inviata";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id =  " + id + " non trovato");
        }
    }

    private void sendMail(String email,String nome,String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione nuovo Dipendente");
        message.setText("Ciao " + nome + ",Bevenuto nella nostra azienda, il tuo username per accedere alla nostra piattaforma é " + username);

        javaMailSender.send(message);
    }

    public Dipendente getDipendenteByEmail(String email) {
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findByEmail(email);
        if(dipendenteOptional.isPresent()){
            return dipendenteOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato");
        }
    }

}
