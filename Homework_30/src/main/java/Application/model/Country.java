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
@Table(name = "Country")
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "IP", unique = true, nullable = false)
    private String ip;

    @Column(name = "Country")
    private String country;

    @Column(name = "Country_code")
    private String countryCode;

    @Column(name = "City")
    private String city;

    @Column(name = "Currency")
    private String currency;
}
