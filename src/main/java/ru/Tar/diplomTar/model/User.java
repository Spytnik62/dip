package ru.Tar.diplomTar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nickname;
    @Column(length = 150)
    private String email;
    @Column
    private String password;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
    @ManyToMany
    @JoinTable(
            name = "user_horse_project", // Название промежуточной таблицы
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "horse_project_id")
    )
    private List<HorseProject> horseProjects;
    @OneToOne(cascade = CascadeType.ALL) // Указываем каскадное сохранение
    @JoinColumn(name = "user_parameters_id") // Название внешнего ключа
    private UserParameters userParameters;

}
