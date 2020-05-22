package com.example.backend6.Models.ViewModels;

import com.example.backend6.Models.PostCategories;

public class PostViewModel {

    private String Text;

    private String Title;

    private PostCategories postcategories;

    public PostCategories getPostcategories() {
        return postcategories;
    }

    public void setPostcategories(PostCategories postcategories) {
        this.postcategories = postcategories;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }



}
