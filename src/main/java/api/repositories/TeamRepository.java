package api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.models.Team;;

@RepositoryRestResource(collectionResourceRel = "team", path = "team")
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(@Param("name") String name);
}
