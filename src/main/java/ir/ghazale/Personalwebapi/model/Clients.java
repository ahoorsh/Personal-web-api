package ir.ghazale.Personalwebapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//mark class as an Entity
@Entity
@Getter
@Setter
@Table(name = "CLIENTS")
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASS_WORD")
    private String password;
}
