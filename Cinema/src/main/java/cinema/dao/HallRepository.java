package cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cinema.model.Hall;

@RepositoryRestResource
public interface HallRepository extends JpaRepository<Hall, Long>{

}
