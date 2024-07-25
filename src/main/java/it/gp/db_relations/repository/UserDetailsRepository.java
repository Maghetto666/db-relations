package it.gp.db_relations.repository;

import it.gp.db_relations.model.User;
import it.gp.db_relations.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository  extends JpaRepository<UserDetails, Long> {
}
