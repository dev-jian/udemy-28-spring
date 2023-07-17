package me.devjian.restfulwebservices.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.devjian.restfulwebservices.post.Post;
import me.devjian.restfulwebservices.post.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/jpa")
@RestController
public class UserJpaResource {

    private final UserDaoService service;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@Valid @RequestBody Post post, @PathVariable int userId) {
        Optional<User> theUser = userRepository.findById(userId);
        if (theUser.isEmpty()) {
            throw new UserNotFoundException("id = " + userId);
        }

        post.setUser(theUser.get());
        Post newPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveAllUsers(@PathVariable int id) {
        Optional<User> theUser = userRepository.findById(id);
        if (theUser.isEmpty()) {
            throw new UserNotFoundException("id = " + id);
        }
        return theUser.get();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int userId) {
        Optional<User> theUser = userRepository.findById(userId);
        if (theUser.isEmpty()) {
            throw new UserNotFoundException("id = " + userId);
        }
        return theUser.get().getPosts();
    }
}
