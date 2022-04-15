package Application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Subscriber")
@AllArgsConstructor
public class Subscriber {

    @Id
    @Column(name = "IP")
    private String ip;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Second_name")
    private String secondName;

    @Column(name = "Gender")
    private String gender;
}
