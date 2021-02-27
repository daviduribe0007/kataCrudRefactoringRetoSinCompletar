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
public class TodoController {

    @Autowired
    private TodoDTA service;

    @GetMapping(value = "todo/all")
    public Iterable<TodoDTO> list() {
        return service.list();
    }

    @PostMapping(value = "todo/post")
    public TodoDTO save(@Validated @RequestBody TodoDTO todoDTO) {
        return service.save(todoDTO);
    }

    @PutMapping(value = "todo/put")
    public TodoDTO update(@Validated @RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null) {
            return service.save(todoDTO);
        }
        throw new RuntimeException("The id not exist to update");

        /*
        * public Todo save(Todo todo){
        try {
            validateLength(todo);
        }catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
        return repository.save(todo);
    }

    private void validateLength(Todo todo) {
        if(todo.getName().length()<3 || todo.getName().length()>100){
            throw new IllegalArgumentException("Se permiten caracteres de 3 hasta 100");
        }
    }
        * */

    }

    @DeleteMapping(value = "todo/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        if (id != null) {
            service.delete(id);
        }
        throw new RuntimeException("The id not exist to delete");
    }

    @GetMapping(value = "todo/{id}/get")
    public TodoDTO get(@PathVariable("id") Long id) {
        if (id != null) {
            return service.get(id);
        }
        throw new RuntimeException("The id not exist");
    }

}
