package Application.repository;

import Application.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {

    @Query(value = "DELETE FROM ToDoList WHERE ToDoList.ID = (SELECT * FROM (SELECT MAX(ToDoList.ID) FROM ToDoList) AS tableAbstract)", nativeQuery = true)
    @Modifying
    void deleteRowFromTheEnd(); /*@Query(value = "delete from ToDoList order by ID desc limit 1", nativeQuery = true) */

    @Query(value = "UPDATE ToDoList t SET t.note = :note WHERE t.id = :id", nativeQuery = true)
    @Modifying
    void updateTextById(@Param("note") String text, @Param("id") Integer id);

    @Modifying
    void deleteById(Integer id);

    @Query(value = "UPDATE ToDoList t SET t.Is_Done = :status WHERE t.id=:id", nativeQuery = true)
    @Modifying
    void updateNoteStatusById(@Param("status") Boolean status, @Param("id") Integer id);
}
