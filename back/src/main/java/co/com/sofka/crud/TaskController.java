package co.com.sofka.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskDTA service;

    @GetMapping(value = "task/all")
    public Iterable<TaskDTO> list() {
        return service.list();
    }

    @PostMapping(value = "task/post")
    public TaskDTO save(@Validated @RequestBody TaskDTO taskDTO) {
        return service.save(taskDTO);
    }

    @PutMapping(value = "task/put")
    public TaskDTO update(@Validated @RequestBody TaskDTO tasDTO) {
        if (tasDTO.getId() != null) {
            return service.save(tasDTO);
        }
        throw new RuntimeException("The id not exist to update");
    }

    @DeleteMapping(value = "task/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        if (id != null) {
            service.delete(id);
        }
        throw new RuntimeException("The id not exist to delete");
    }

    @GetMapping(value = "task/{id}/get")
    public TaskDTO get(@PathVariable("id") Long id) {
        if (id != null) {
            return service.get(id);
        }
        throw new RuntimeException("The id not exist");
    }

}
