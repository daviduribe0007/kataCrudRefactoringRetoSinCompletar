package co.com.sofka.crud;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskDTO, Long> {

}
