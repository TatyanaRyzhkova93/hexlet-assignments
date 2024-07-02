package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream().map(this::toDTO).toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO index(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return toDTO(post);
    }

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        var comments = commentRepository.findByPostId(post.getId())
                .stream().map(this::toCommentDTO).toList();
        dto.setComments(comments);
        return dto;
    }

    private CommentDTO toCommentDTO(Comment comment) {
        var dto = new CommentDTO();
        dto.setBody(comment.getBody());
        dto.setId(comment.getId());
        return dto;
    }
}