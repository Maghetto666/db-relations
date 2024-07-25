package it.gp.db_relations.repository;

import it.gp.db_relations.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
