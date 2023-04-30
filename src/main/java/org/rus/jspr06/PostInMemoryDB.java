package org.rus.jspr06;


import org.rus.jspr06.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public final class PostInMemoryDB {
    private final AtomicLong currentId = new AtomicLong(0);

    private final List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public long incrementAndGet() {
        return currentId.incrementAndGet();
    }
}
