package com.miguelmacario.workshopmongo.services;

import com.miguelmacario.workshopmongo.domain.Post;
import com.miguelmacario.workshopmongo.repository.PostRepository;
import com.miguelmacario.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto nao econtrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate){
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
    

}
