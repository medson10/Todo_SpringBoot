package api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.models.Member;;

@RepositoryRestResource(collectionResourceRel = "member", path = "member")
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByName(@Param("name") String name);
}
