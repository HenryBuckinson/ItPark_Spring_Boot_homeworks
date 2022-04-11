package homework_35.service;

import homework_35.dto.ToDoListDto;

import java.util.List;

public interface ToDoListService {
    List<ToDoListDto> findAll();

    ToDoListDto add(ToDoListDto note);

    void deleteRowFromTheEnd();

    void updateNoteById(String text, Integer id);

    void deleteEmptyNoteById(Integer id);

    void switchStatusOfNoteById(Boolean status, Integer id);
}
