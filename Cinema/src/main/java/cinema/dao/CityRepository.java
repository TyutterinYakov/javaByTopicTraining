package cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cinema.model.City;

@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Long>{

}
