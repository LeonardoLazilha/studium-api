package com.studium.domain.student.dto;

import com.studium.domain.address.AddressCreateDTO;
import com.studium.domain.student.Gender;
import com.studium.domain.student.Modality;
import com.studium.domain.student.Race;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record StudentCreateDTO(

        @Size(max = 10, message = "SID deve conter no máximo 10 caracteres")
        String sid,

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 1, max = 255, message = "Nome deve conter entre 1 e 255 caracteres")
        String name,

        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate birth,

        @NotNull(message = "Raça é obrigatória")
        Race race,

        @NotNull(message = "Gênero é obrigatório")
        Gender gender,

        @NotNull(message = "Modalidade é obrigatório")
        Modality modality,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        @Size(min = 10, max = 20, message = "Telefone deve conter entre 10 e 20 caracteres")
        String phone,

        @NotBlank(message = "CPF é obrigatório")
        @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
        String cpf,

        @NotEmpty(message = "O endereço nao pode ser vazio.")
        List<AddressCreateDTO> addresses

) {
}