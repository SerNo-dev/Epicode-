package it.epicode.E2.service;


import it.epicode.E2.Dto.BlogPostDto;
import it.epicode.E2.exception.AutoreNonTrovatoException;
import it.epicode.E2.exception.PostNonTrovatoException;
import it.epicode.E2.model.AutoreBlog;
import it.epicode.E2.model.Blog;
import it.epicode.E2.repository.AutoreRepository;
import it.epicode.E2.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService {


    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreRepository autoreRepository;


    public String saveBlogPost(BlogPostDto blogPostDto) {

        Blog blogPost = new Blog();
        blogPost.setTitolo(blogPostDto.getTitolo());
        blogPost.setCategoria(blogPostDto.getCategoria());
        blogPost.setContenuto(blogPostDto.getContenuto());
        blogPost.setCover(blogPostDto.getCover());
        blogPost.setTempoDiLETTURA(blogPostDto.getTempoDiLettura());


        Optional<AutoreBlog> autoreBlogOptional = autoreRepository.findById(blogPostDto.getAutoreId());

        if (autoreBlogOptional.isPresent()) {
            AutoreBlog autoreBlog = autoreBlogOptional.get();
            blogPost.setAutore(autoreBlog);

            blogPostRepository.save(blogPost);
            return "Blog post con titolo " + blogPost.getId() + " salvAato corettamente";
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato con id " + blogPostDto.getAutoreId());
        }

    }

    public List<Blog> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }


  public Page<Blog> getBlogPosts(int page, int size, String sortBy) {
       Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
      return blogPostRepository.findAll(pageable);
    }

    public Optional<Blog> getBlogPostById(int id) {
        return blogPostRepository.findById(id);
    }

    public Blog updateBlogPost(int id, BlogPostDto blogPostDto) {
        Optional<Blog> blogPostOptional = getBlogPostById(id);
        if (blogPostOptional.isPresent()) {
            Blog blogPost = blogPostOptional.get();
            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setContenuto(blogPostDto.getContenuto());
            blogPost.setCover(blogPostDto.getCover());
            blogPost.setTempoDiLETTURA(blogPostDto.getTempoDiLettura());


            Optional<AutoreBlog> autoreBlogOptional = autoreRepository.findById(blogPostDto.getAutoreId());

            if (autoreBlogOptional.isPresent()) {
                AutoreBlog autoreBlog = autoreBlogOptional.get();
                blogPost.setAutore(autoreBlog);

                blogPostRepository.save(blogPost);
                return blogPost;
            } else {
                throw new AutoreNonTrovatoException("Autore non trovato con id " + blogPostDto.getAutoreId());
            }
        } else {
            throw new PostNonTrovatoException("Blog con id " + id + " non trovato");
        }
    }

    public String deleteBlogPost(int id) {
        Optional<Blog> blogOpt = getBlogPostById(id);
        if (blogOpt.isPresent()) {
            blogPostRepository.delete(blogOpt.get());
            return "Blog con id = " + id + " eliminato con successo";
        } else {
            throw new PostNonTrovatoException("Blog con id = " + id + " non trovato");
        }
    }
}
