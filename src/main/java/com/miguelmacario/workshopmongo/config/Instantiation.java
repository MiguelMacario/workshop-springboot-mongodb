package com.miguelmacario.workshopmongo.config;

import com.miguelmacario.workshopmongo.domain.Post;
import com.miguelmacario.workshopmongo.domain.User;
import com.miguelmacario.workshopmongo.dto.AuthorDTO;
import com.miguelmacario.workshopmongo.dto.CommentDTO;
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

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",new AuthorDTO(alex), LocalDate.parse("21/03/2018", formatter));
        CommentDTO c2 = new CommentDTO("Aproveite!",new AuthorDTO(bob), LocalDate.parse("22/03/2018", formatter));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", new AuthorDTO(alex), LocalDate.parse("23/03/2018", formatter));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);



    }
}
