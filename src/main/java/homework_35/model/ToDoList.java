package homework_35.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ToDoList")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer order;

    @Column(name = "Note",columnDefinition = "VARCHAR(255) DEFAULT 'New note...'")
    private String note;

    @Column(name = "Date",columnDefinition = "TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP'")
//    @CreationTimestamp
    private Date date;

    @Column(name = "Is_Done",columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean is_Done;

}
