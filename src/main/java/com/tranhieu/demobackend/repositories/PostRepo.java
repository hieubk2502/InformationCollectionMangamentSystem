package com.tranhieu.demobackend.repositories;

import com.tranhieu.demobackend.entities.Category;
import com.tranhieu.demobackend.entities.Post;
import com.tranhieu.demobackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    @Query("select p from Post p where p.title like:key")
    List<Post> findByTitleContaining(@Param("key") String title);
}
