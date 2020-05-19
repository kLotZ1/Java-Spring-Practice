package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.Models.PostCategories;
import com.example.backend6.Repositories.PostCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/postcategories")
public class PostCategoriesController {

    @Autowired
    private PostCategoriesRepository postCategoriesRepository;

    @PostMapping("/create")
    public String createPost(@ModelAttribute("model") PostCategories model){
        PostCategories tPostCat = new PostCategories();
        tPostCat.setName(model.getName());
        postCategoriesRepository.save(tPostCat);
        return "redirect:/postcategories/index";
    }
    @GetMapping("/create")
    public String createGet(Model model){
        model.addAttribute("model", new PostCategories());
        return "fragments/postcategories/create";
    }

    @GetMapping("/index")
    public String getAllPosts(Model model){
        model.addAttribute("model", postCategoriesRepository.findAll());
        return "fragments/postcategories/index";
    }
}
