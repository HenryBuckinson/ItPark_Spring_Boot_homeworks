package Application.mapper;

import Application.dto.ToDoListDto;
import Application.model.ToDoList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface ToDoListMapper {

    @Mapping(target = "order", source = "entity.order")
    @Mapping(target = "note", source = "entity.note")
    @Mapping(target = "date", source = "entity.date")
    @Mapping(target = "is_Done", source = "entity.is_Done")
    ToDoListDto toDto(ToDoList entity);

    @Mapping(target = "order", source = "dto.order")
    @Mapping(target = "note", source = "dto.note")
    @Mapping(target = "date", source = "dto.date")
    @Mapping(target = "is_Done", source = "dto.is_Done")
    ToDoList toEntity(ToDoListDto dto);

    default List<ToDoListDto> toDto(List<ToDoList> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<ToDoListDto> toOptionalDtos(Optional<ToDoList> entity) {
        return entity.map(this::toDto);
    }
}
