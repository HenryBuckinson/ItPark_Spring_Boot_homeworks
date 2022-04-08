package homework_35.service.Impl;

import homework_35.dto.ToDoListDto;
import homework_35.mapper.ToDoListMapper;
import homework_35.repository.ToDoListRepository;
import homework_35.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    @Modifying
//    @Query(value = "DELETE FROM ToDoList WHERE ToDoList.ID = (SELECT * FROM (SELECT MAX(ToDoList.ID) FROM ToDoList) AS tableAbstract)", nativeQuery = true)
    @Query(value = "DELETE FROM ToDoList WHERE ToDoList.order = 4")
    public void deleteRowFromTheEnd() {

    }

    @Override
    @Transactional
    @Modifying
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


}
