package ru.Tar.diplomTar.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "contact_request")
public class ContactRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String totalArea;
    @Column
    private String foundationType;
    @Column
    private String wallMaterial;
    @Column
    private String roofType;
}
