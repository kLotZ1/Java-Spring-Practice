package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping(path="/Post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/create")
    public String createPost(@ModelAttribute("model") Post model){
        Post tPost = new Post();
        tPost.setText(model.getText());
        tPost.setTitle(model.getTitle());
        tPost.setCreated(Date.from(Instant.now()));
        tPost.setModified(Date.from(Instant.now()));
        postRepository.save(tPost);
        return "redirect:/Post/index";
    }
    @GetMapping("/create")
    public String createGet(Model model){
        model.addAttribute("model", new Post());
        return "fragments/Post/create";
    }
    @GetMapping("/index")
    public String getAllPosts(Model model){
        model.addAttribute("model", postRepository.findAll());
        return "fragments/Post/index";
    }
}
