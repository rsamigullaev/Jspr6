package org.rus.jspr06;


import org.rus.jspr06.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAll() {
        return repository.getAll();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(IllegalAccessError::new);
    }

    public Post upsert(Post post) {
        return repository.upsert(post);
    }

    public boolean removeById(long id) {
        repository.removeById(id);
        return true;
    }
}