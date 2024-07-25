package it.gp.db_relations.repository;

import it.gp.db_relations.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
