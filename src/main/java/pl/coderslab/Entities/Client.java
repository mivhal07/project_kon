package pl.coderslab.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    @NotNull
    private String email;
    @NotNull
    @Column(unique = true, nullable = false)
    private Long pesel;
    private String firstName;
    private String lastName;
    private String address;
}
