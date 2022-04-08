package homework_35.controller;

import homework_35.dto.ToDoListDto;
import homework_35.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class ToDoListController {

    private final ToDoListService service;


    @GetMapping
    public String index(Model model) {
        List<ToDoListDto> allNotes = service.findAll();
        model.addAttribute("allNotes", allNotes);
        return "notes";
    }

    @PostMapping("/add")
    public String addNote(){
        service.add(new ToDoListDto());
        return "redirect:/notes";
    }

//    @PostMapping("/delete")
//    public String deleteRow(){
//        service.deleteRowFromTheEnd();
//        return "redirect:/notes";
//    }

}
