package Application.service.Impl;

import Application.dto.ToDoListDto;
import Application.mapper.ToDoListMapper;
import Application.repository.ToDoListRepository;
import Application.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository repository;
    private final ToDoListMapper mapper;


    @Override
    @Transactional(readOnly = true)
    public List<ToDoListDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    @Transactional
    public ToDoListDto add(ToDoListDto note) {
        return mapper.toDto(repository.save(mapper.toEntity(note)));
    }

    @Override
    @Transactional
    public void deleteRowFromTheEnd() {
        repository.deleteRowFromTheEnd();
    }

    @Override
    @Transactional
    public void updateNoteById(String text, Integer id) {
        repository.updateTextById(text, id);
    }

    @Override
    @Transactional
    public void deleteEmptyNoteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void switchStatusOfNoteById(Boolean status, Integer id) {
        repository.updateNoteStatusById(status, id);
    }
}
