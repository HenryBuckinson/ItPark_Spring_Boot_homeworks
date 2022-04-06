package homework_35.controller;

import homework_35.dto.ToDoListDto;
import homework_35.model.ToDoList;
import homework_35.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ToDoListController {

    private final ToDoListService service;


    @GetMapping
    public String index(Model model) {
        ToDoListDto save = service.add(new ToDoListDto());//для проверки того, корректно ли создана запись
        List<ToDoListDto> allNotes = service.findAll();
        model.addAttribute("allNotes", allNotes);
        return "notes";
    }

//    @PostMapping
//    public String addNote(Model model,
//                          @ModelAttribute("allNotes") List<ToDoListDto> allNotes){
//        ToDoListDto save = service.add(new ToDoListDto(" "));
//        model.addAttribute("save",save);
//        model.addAttribute("allNotes", allNotes);
//        return "redirect:/notes";
//    }

}
