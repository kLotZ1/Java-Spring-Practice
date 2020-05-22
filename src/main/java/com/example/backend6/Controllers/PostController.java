package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.Repositories.PostCategoriesRepository;
import com.example.backend6.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostCategoriesRepository postCategoriesRepository;

    @PostMapping("/create")
    public String createPost(@ModelAttribute("model") Post model) {
        Post tPost = new Post();
        tPost.setText(model.getText());
        tPost.setTitle(model.getTitle());
        tPost.setCreated(Date.from(Instant.now()));
        tPost.setModified(Date.from(Instant.now()));
        tPost.setPostcategories(model.getPostcategories());
        postRepository.save(tPost);
        return "redirect:/post/index";
    }

    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", postCategoriesRepository.findAll());
        return "fragments/post/create";
    }
    @GetMapping("/delete/{id}")
    public String postDeleteGet(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postRepository.findById(id).get());
        return "fragments/post/delete";
    }

    @PostMapping("/delete/{id}")
    public String postDeletePost(@PathVariable("id") Integer id) {
        Post tPost = postRepository.findById(id).get();

        postRepository.delete(tPost);
        return "redirect:/post/index";
    }

    @GetMapping("/details/{id}")
    public String postDetailsGet(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postRepository.findById(id).get());
        return "fragments/post/details";
    }

    @GetMapping("/index")
    public String getAllPosts(Model model) {
        model.addAttribute("model", postRepository.findAll());
        return "fragments/post/index";
    }
}
