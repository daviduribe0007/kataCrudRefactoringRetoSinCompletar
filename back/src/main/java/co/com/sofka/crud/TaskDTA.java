package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDTA {

    @Autowired
    private TaskRepository repository;

    public Iterable<TaskDTO> list() {
        return repository.findAll();
    }

    public TaskDTO save(TaskDTO taskDTO) {
        return repository.save(taskDTO);
    }

    public void delete(Long id) {
        repository.delete(get(id));
    }

    public TaskDTO get(Long id) {
        return repository.findById(id).orElseThrow();
    }

}
