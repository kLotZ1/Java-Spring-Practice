package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.Models.ViewModels.PostViewModel;
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

    //CREATE
    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("post", new PostViewModel());
        model.addAttribute("categories", postCategoriesRepository.findAll());
        return "fragments/post/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("model") PostViewModel model) {
        Post tPost = new Post();
        tPost.setText(model.getText());
        tPost.setTitle(model.getTitle());
        tPost.setCreated(Date.from(Instant.now()));
        tPost.setModified(Date.from(Instant.now()));
        tPost.setPostcategories(model.getPostcategory());
        postRepository.save(tPost);
        return "redirect:/post/index";
    }

    //DELETE
    @GetMapping("/delete/{id}")
    public String postDeleteGet(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("post", postRepository.findById(id).get());
        return "fragments/post/delete";
    }

    @PostMapping("/delete/{id}")
    public String postDeletePost(@PathVariable("id") Integer id) {

        postRepository.deleteById(id);
        return "redirect:/post/index/";
    }

    @GetMapping("/edit/{id}")
    public String postEditGet(@PathVariable("id") Integer id, Model model) {

        Post post = postRepository.findById(id).get();

        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setTitle(post.getTitle());
        postViewModel.setText(post.getText());
        postViewModel.setPostcategory(post.getPostcategories());
        model.addAttribute("post", postViewModel);
        model.addAttribute("categories", postCategoriesRepository.findAll());
        return "fragments/post/edit";
    }
    @PostMapping("/edit/{id}")
    public String postEditPost(@ModelAttribute("model") PostViewModel model, @PathVariable("id") Integer id) {
        Post tPost = postRepository.findById(id).get();
        tPost.setText(model.getText());
        tPost.setTitle(model.getTitle());
        tPost.setModified(Date.from(Instant.now()));
        tPost.setPostcategories(model.getPostcategory());
        postRepository.save(tPost);
        return "redirect:/post/details/{id}";
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
