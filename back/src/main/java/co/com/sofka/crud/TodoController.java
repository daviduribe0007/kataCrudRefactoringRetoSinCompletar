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
    public TodoDTO save(@RequestBody TodoDTO todoDTO) {
        return service.save(todoDTO);
    }

    @PutMapping(value = "todo/put")
    public TodoDTO update(@Validated @RequestBody TodoDTO todoDTO) {
        if (todoDTO.getId() != null && !todoDTO.getName().isEmpty()) {
            return service.save(todoDTO);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "todo/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = "todo/{id}/get")
    public TodoDTO get(@PathVariable("id") Long id) {
        return service.get(id);
    }



}
