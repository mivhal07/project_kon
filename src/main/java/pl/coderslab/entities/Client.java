package pl.coderslab.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email;
    @NotNull
    @Column(unique = true, nullable = false)
    private Long pesel;
    private String firstName;
    private String lastName;
    private String address;
    @OneToOne
    private Order order;
}
