package it.gp.db_relations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.gp.db_relations.model.User;
import it.gp.db_relations.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Tag(name = "Gestione Utenti", description = "Api di gestione utenti")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @Operation(summary = "Recupera utenti", description = "Torna la lista di tutti gli utenti sul database")
    @ApiResponse(responseCode = "200", description = "Utenti recuperati con successo")
    public List<User> getAllUsers() {
        // LOG DELLA CHIAMATA EFFETTUATA
        logger.debug("Chiamata effettuata al metodo getAllUsers()");
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera utente per id", description = "Questo endpoint torna l'utente che ha id passato in ingresso, se presente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utente trovato"),
            @ApiResponse(responseCode = "404", description = "Utente non trovato con l'id specificato")
    })
    public ResponseEntity<User> getUserById(
            @Parameter(name = "id", required = true) @PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            logger.error(("Utente non trovato con id " + id));
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
