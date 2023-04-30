package org.rus.jspr06;


import org.rus.jspr06.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final PostInMemoryDB db;

    public PostRepository(final PostInMemoryDB db) {
        this.db = db;
    }

    public List<Post> getAll() {
        return db.getPosts();
    }

    public Optional<Post> getById(long id) {
        return db.getPosts().stream().filter(it -> it.getId() == id).findFirst();
    }

    public Post upsert(Post post) {
        if (post.getId() == 0) return insert(post);
        return update(post);
    }

    private Post insert(Post post) {
        post.setId(db.incrementAndGet());
        db.getPosts().add(post);
        return post;
    }

    private Post update(Post post) {
        final var oldPost = getById(post.getId()).orElseThrow(IllegalAccessError::new);
        final var oldPostIndex = db.getPosts().indexOf(oldPost);
        db.getPosts().remove(oldPostIndex);
        db.getPosts().add(oldPostIndex, post);
        return post;
    }

    public boolean removeById(long id) {
        final var post = getById(id).orElseThrow(IllegalAccessError::new);
        return db.getPosts().remove(post);
    }
}
