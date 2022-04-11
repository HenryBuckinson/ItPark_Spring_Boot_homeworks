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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/update/{note}/{id}")
    public void updateNote(@PathVariable("note") String text, @PathVariable("id") Integer id) {
        service.updateNoteById(text, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/update/{id}")
    public void deleteEmptyNote(@PathVariable("id") Integer id) {
        service.deleteEmptyNoteById(id);
    }

    @PostMapping("/progress/{id}/{isDone}")
    public void noteInProgress(@PathVariable("id") Integer id, @PathVariable("isDone") String isDone) {
        Boolean response = Boolean.parseBoolean(isDone);
        service.switchStatusOfNoteById(response, id);
    }

}
