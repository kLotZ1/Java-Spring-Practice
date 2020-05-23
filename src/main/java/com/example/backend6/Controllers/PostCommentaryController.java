package com.example.backend6.Controllers;

import com.example.backend6.Models.Post;
import com.example.backend6.Models.PostCommentary;
import com.example.backend6.Models.ViewModels.PostCommentaryViewModel;
import com.example.backend6.Repositories.PostCommentaryRepository;
import com.example.backend6.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;

@Controller
@RequestMapping("/postcommentary")
public class PostCommentaryController {

    @Autowired
    private PostCommentaryRepository postCommentaryRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/create/{id}")
    public String createComment(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("postcommentary", new PostCommentaryViewModel());
        return "fragments/postcommentary/create";
    }

    @PostMapping("/create/{id}")
    public String createComment(@PathVariable("id") Integer id, PostCommentaryViewModel model) {
        Post post = postRepository.findById(id).get();
        PostCommentary newComment = new PostCommentary();

        newComment.setText(model.getText());
        newComment.setCreated(Date.from(Instant.now()));
        newComment.setModified(Date.from(Instant.now()));
        newComment.setPost(post);

        postCommentaryRepository.save(newComment);

        return "redirect:/post/index";
    }
}
