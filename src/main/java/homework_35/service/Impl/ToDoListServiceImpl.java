package homework_35.service.Impl;

import homework_35.dto.ToDoListDto;
import homework_35.mapper.ToDoListMapper;
import homework_35.repository.ToDoListRepository;
import homework_35.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
