package ru.tiger.bookprototype.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tiger.bookprototype.entity.Post;

@RestController
//@RequestMapping("api/post")
public class PostController {
    private Map<Integer, Post> posts = new HashMap<>();
    private int idCounter = 1;
    
    @RequestMapping(path = "api/post", method = RequestMethod.POST/*, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public String addPost(@RequestBody Post post) {
        System.out.println("<< POST post");
        int id  = idCounter++;
        post.setId((long) id);
        posts.put(id, post);
        
        System.out.println("<< Add post: " + post);
        
        return "{\"msg\":\"ok\"}";
    }

    @RequestMapping(path = "api/post/{id}", method = RequestMethod.GET)
    public Post findPost(@PathVariable int id) {
        System.out.println("<< GET post");
        Post post = null;
        post = posts.get(id);
        
        post = new Post();
        post.setId((long) id);
        post.setHeader("Header!");
        post.setContent("Content...");
        
        System.out.println("<< Find post: " + post);
        
        return post;
    }
    
    public List<Post> findAllPost() {
        return null;
    }
    
    /*@RequestMapping(path = "api/post/{id}", method = RequestMethod.POST)
    public void updatePost(@PathVariable int id, ) {
        
    }*/
    
    @RequestMapping(path = "api/post/{id}", method = RequestMethod.DELETE)
    public void removePost(@PathVariable int id) {
        Post post = posts.remove(id);
        
        System.out.println("<< Remove post: " + post);
    }
}

/*
How to check?

GET
$.ajax({url:"api/post/1",method:"GET",type:"text/json",success:function(data){console.log("Success:");console.log(data);},error:function(data){console.log("Error: "+data);}});

POST
$.ajax({url:"api/post",method:"POST",type:"text/json",data:'{"header":"Заголовок","content":"Текст статьи"}',success:function(data){console.log("Success:");console.log(data);},error:function(data){console.log("Error: "+data);}});

PUT

DELETE


*/