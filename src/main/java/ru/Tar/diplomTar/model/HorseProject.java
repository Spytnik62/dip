package ru.Tar.diplomTar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "horse_projects")
public class HorseProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Другие поля...

    @ManyToMany(mappedBy = "horseProjects")
    private List<User> users;

    @Column
    private String houseLocation;
    @Column
    private String houseType;
    @Column
    private String houseFloors;
    @Column
    private String houseMaterial;
    @Column
    private String houseRoofType;
    @Column
    private String houseArea;
}
