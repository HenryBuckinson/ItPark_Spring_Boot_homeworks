package homework_35.controller.rest;

import homework_35.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class ToDoListRestController {

    private final ToDoListService service;

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRow(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

}
