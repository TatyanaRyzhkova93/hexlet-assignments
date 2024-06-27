package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

@RestController
@RequestMapping("/api")
public class PostsController {
    List<Post> allPosts = Data.getPosts();
    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable Integer id) {
        return allPosts.stream()
                .filter(p -> (p.getUserId() == id)).toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post created(@PathVariable Integer id, @RequestBody Post data) {
        var post = new Post();
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        post.setUserId(id);
        post.setSlug(data.getSlug());
        allPosts.add(post);
        return post;
    }
}
