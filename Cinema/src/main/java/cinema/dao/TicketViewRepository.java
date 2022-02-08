package cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cinema.model.TicketView;

@RepositoryRestResource
public interface TicketViewRepository extends JpaRepository<TicketView, Long>{

}
