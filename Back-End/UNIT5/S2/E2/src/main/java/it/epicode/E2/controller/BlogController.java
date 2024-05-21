package it.epicode.E2.controller;


import it.epicode.E2.exception.PostNonTrovatoException;
import it.epicode.E2.model.Blog;
import it.epicode.E2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping("/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlogPost(@RequestBody Blog post) {
        return blogService.saveBlogPost(post);
    }

    @GetMapping("/blogPosts")
    public List<Blog> getAllBlogPosts() {
        return blogService.getAllBlogPosts();
    }

    @GetMapping("/blogPosts/{id}")
    public Blog getBlogPost(@PathVariable int id) throws PostNonTrovatoException {
        Optional<Blog> blogOpt = blogService.getBlogPostById(id);
        if (blogOpt.isPresent()) {
            return blogOpt.get();
        } else {
           throw new PostNonTrovatoException("Blog con id " + id + " non trovato");
        }
    }

    @PutMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog updateBlogPost(@PathVariable int id, @RequestBody Blog post) throws PostNonTrovatoException {
        return blogService.updateBlogPost(id, post);
    }

    @DeleteMapping("/blogPosts/{id}")
    public String deleteBlogPost(@PathVariable int id) throws PostNonTrovatoException {
        return blogService.deleteBlogPost(id);
    }
}
