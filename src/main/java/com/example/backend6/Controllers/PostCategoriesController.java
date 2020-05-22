package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.Models.PostCategories;
import com.example.backend6.Models.ViewModels.PostCategoriesViewModel;
import com.example.backend6.Models.ViewModels.PostViewModel;
import com.example.backend6.Repositories.PostCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/postcategories")
public class PostCategoriesController {

    @Autowired
    private PostCategoriesRepository postCategoriesRepository;

    @PostMapping("/create")
    public String createPost(@ModelAttribute("postcategory") PostCategories model) {
        PostCategories tPostCat = new PostCategories();
        tPostCat.setName(model.getName());
        postCategoriesRepository.save(tPostCat);
        return "redirect:/postcategories/index";
    }

    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("postcategory", new PostCategories());
        return "fragments/postcategories/create";
    }

    @GetMapping("/index")
    public String getAllPostCategories(Model model) {
        model.addAttribute("postcategory", postCategoriesRepository.findAll());
        return "fragments/postcategories/index";
    }

    @GetMapping("/edit/{id}")
    public String postCategoriesEditGet(@PathVariable("id") Integer id, Model model) {

        PostCategories postCat = postCategoriesRepository.findById(id).get();

        PostCategoriesViewModel postCatViewModel = new PostCategoriesViewModel();
        postCatViewModel.setName(postCat.getName());
        model.addAttribute("postcategory", postCatViewModel);
        return "fragments/postcategories/edit";
    }

    @PostMapping("/edit/{id}")
    public String postEditPost(@ModelAttribute("model") PostCategoriesViewModel model, @PathVariable("id") Integer id) {
        PostCategories postCat = postCategoriesRepository.findById(id).get();
        postCat.setName(model.getName());
        postCategoriesRepository.save(postCat);
        return "redirect:/postcategories/index";
    }
}
