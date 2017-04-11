package api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import api.models.Task;;

@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByHours(@Param("hours") long hours);
}
