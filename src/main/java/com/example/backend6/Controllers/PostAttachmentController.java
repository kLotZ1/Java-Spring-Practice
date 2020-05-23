package com.example.backend6.Controllers;

import com.example.backend6.Models.ViewModels.PostAttachmentViewModel;
import com.example.backend6.Repositories.PostAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/postattachment")
public class PostAttachmentController {

    @Autowired
    private PostAttachmentRepository postAttachmentRepository;

    @GetMapping("/create/{id}")
    public String addAttachment(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("postattachment",new PostAttachmentViewModel());
        return "fragments/postattachment/create";
    }

    @PostMapping("/create/{id}")
    public String addAttachment(@ModelAttribute("model") PostAttachmentViewModel model, @PathVariable("id") Integer id) {
        
        return "redirect:/postcategories/index";
    }

}
