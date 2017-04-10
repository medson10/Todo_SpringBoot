package tasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "task", path = "task")
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findById(@Param("id") long id);
}
