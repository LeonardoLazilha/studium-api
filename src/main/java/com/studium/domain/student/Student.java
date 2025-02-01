package com.studium.domain.student;

import com.studium.domain.address.Address;
import com.studium.domain.student.dto.StudentCreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Student")
@Table(name = "STUDENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid", nullable = false, unique = true)
    private String sid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(name = "race", nullable = false)
    private Race race;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    @Enumerated (EnumType.STRING)
    @Column(name = "modality", nullable = false)
    private Modality modality;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "dh_insert", nullable = false, updatable = false)
    private LocalDateTime dhInsert;

    @Column(name = "dh_update")
    private LocalDateTime dhUpdate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        dhInsert = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        dhUpdate = LocalDateTime.now();
    }

    public Student(StudentCreateDTO dto) {
        this.name = dto.name();
        this.birth = dto.birth();
        this.race = dto.race();
        this.gender = dto.gender();
        this.modality = dto.modality();
        this.email = dto.email();
        this.phone = dto.phone();
        this.cpf = dto.cpf();
        this.status = Status.ACTIVE;
        this.addresses.addAll(dto.addresses().stream().map(it -> new Address(it, this)).toList());
    }


    public String generateSid(Modality modality){
        int currentYear = LocalDate.now().getYear();

        int birthMonth = this.birth.getMonthValue();
        int birthDay = this.birth.getDayOfMonth();

        String modalityCode = modality == Modality.EAD ? "-5" : "-2";

        return String.format("%d%02d%02d%s", currentYear, birthMonth, birthDay, modalityCode);
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

}
