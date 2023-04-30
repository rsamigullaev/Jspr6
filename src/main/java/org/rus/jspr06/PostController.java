package org.rus.jspr06;

import org.rus.jspr06.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public final class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public Post upsert(@RequestBody Post post) {
        return service.upsert(post);
    }

    @DeleteMapping("/{id}")
    public void removeById(long id) {
        service.removeById(id);
    }
}
