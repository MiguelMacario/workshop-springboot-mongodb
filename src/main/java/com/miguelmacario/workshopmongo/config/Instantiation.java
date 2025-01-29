package com.miguelmacario.workshopmongo.config;

import com.miguelmacario.workshopmongo.domain.Post;
import com.miguelmacario.workshopmongo.domain.User;
import com.miguelmacario.workshopmongo.dto.AuthorDTO;
import com.miguelmacario.workshopmongo.repository.PostRepository;
import com.miguelmacario.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, "Vou viajar para São Paulo. Abraços!", "Partiu viagem", LocalDate.parse("21/03/2018", formatter), new AuthorDTO(maria));
        Post post2 = new Post(null, "Acordei feliz hoje!", "Bom dia", LocalDate.parse("23/03/2018", formatter), new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
