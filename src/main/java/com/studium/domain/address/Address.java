package com.studium.domain.address;

import com.studium.domain.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Address")
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "cep", nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Address(AddressCreateDTO dto, Student student){
        this.street = dto.street();
        this.number = dto.number();
        this.complement = dto.complement();
        this.district = dto.district();;
        this.city = dto.city();
        this.state = dto.state();
        this.cep = dto.cep();
        this.student = student;
    }


}
