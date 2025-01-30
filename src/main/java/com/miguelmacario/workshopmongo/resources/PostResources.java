package com.miguelmacario.workshopmongo.resources;

import com.miguelmacario.workshopmongo.domain.Post;
import com.miguelmacario.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService postService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
