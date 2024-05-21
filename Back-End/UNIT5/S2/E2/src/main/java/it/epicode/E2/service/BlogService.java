package it.epicode.E2.service;


import it.epicode.E2.exception.PostNonTrovatoException;
import it.epicode.E2.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

      private List<Blog> blogposts = new ArrayList<>();

      public Optional<Blog> getBlogPostById(int id) {
          return blogposts.stream().filter(blog -> blog.getId() == id).findFirst();
      }
      public List<Blog> getAllBlogPosts() {
          return blogposts;
      }

      public String saveBlogPost(Blog blog) {
          blogposts.add(blog);
          return "Blog post creato con successo";
      }

      public Blog updateBlogPost(int id, Blog blog) throws PostNonTrovatoException {
          Optional<Blog> blogToUpdate = getBlogPostById(id);
          if (blogToUpdate.isPresent()) {
              blogToUpdate.get().setTitolo(blog.getTitolo());
              blogToUpdate.get().setContenuto(blog.getContenuto());
              blogToUpdate.get().setCover(blog.getCover());
              blogToUpdate.get().setCategoria(blog.getCategoria());
              blogToUpdate.get().setTempoDiLETTURA(blog.getTempoDiLETTURA());
              return blogToUpdate.get();
          } else {
              throw new PostNonTrovatoException("Post non trovato");
          }
      }

      public String deleteBlogPost(int id) throws PostNonTrovatoException {
          Optional<Blog> blogToDelete = getBlogPostById(id);
          if (blogToDelete.isPresent()) {
              blogposts.remove(blogToDelete.get());
              return "Post eliminato con successo";
          } else {
              throw new PostNonTrovatoException("Post non trovato");
          }
      }
}
