package it.epicode.E2.controller;


import it.epicode.E2.Dto.BlogPostDto;
import it.epicode.E2.exception.BadRequestException;
import it.epicode.E2.exception.PostNonTrovatoException;
import it.epicode.E2.model.Blog;
import it.epicode.E2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;


    @PostMapping("/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlogPost(@RequestBody @Validated BlogPostDto blogPostDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
        }
        return blogService.saveBlogPost(blogPostDto);
    }

    @GetMapping("/blogPosts")
    public Page<Blog> getAllBlogPosts(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "id") String sortBy) {
        return blogService.getBlogPosts(page,size,sortBy);
    }


    @GetMapping("/blogPosts/{id}")
    public Blog getBlogPostById(@PathVariable int id) throws PostNonTrovatoException {
        Optional<Blog> blogOpt = blogService.getBlogPostById(id);
        if (blogOpt.isPresent()) {
            return blogOpt.get();
        } else {
           throw new PostNonTrovatoException("Blog con id " + id + " non trovato");
        }
    }

    @PutMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog updateBlogPost(@PathVariable int id, @RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) throws PostNonTrovatoException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("",((s, s2) -> s+s2)));
        }
        return blogService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/blogPosts/{id}")
    public String deleteBlogPost(@PathVariable int id) throws PostNonTrovatoException {
        return blogService.deleteBlogPost(id);
    }
    @PatchMapping("/blogPosts/{id}")
    public String patchCoverPost(@RequestBody MultipartFile cover, @PathVariable int id)  throws IOException {
        return blogService.patchCoverBlogPost(id,cover);
    }


}
