package Application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ToDoList")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer order;

    @Column(name = "Note", nullable = false, insertable = false)
    private String note;

    @Column(name = "Date", nullable = false, insertable = false)
    private Date date;

    @Column(name = "Is_Done", nullable = false, insertable = false)
    private Boolean is_Done;

}
