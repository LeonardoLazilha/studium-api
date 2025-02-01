package com.studium.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressCreateDTO(

        @NotBlank(message = "Rua é obrigatória")
        @Size(max = 255, message = "Rua deve ter no máximo 255 caracteres")
        String street,

        @NotBlank(message = "Número é obrigatório")
        @Size(max = 20, message = "Número deve ter no máximo 20 caracteres")
        String number,

        @Size(max = 255, message = "Complemento deve ter no máximo 255 caracteres")
        String complement,

        @NotBlank(message = "Bairro é obrigatório")
        @Size(max = 100, message = "Bairro deve ter no máximo 100 caracteres")
        String district,

        @NotBlank(message = "Cidade é obrigatória")
        @Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres")
        String city,

        @NotBlank(message = "Estado é obrigatório")
        @Size(max = 2, message = "Estado deve ter no máximo 2 caracteres")
        String state,

        @NotBlank(message = "CEP é obrigatório")
        @Size(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
        String cep
) {
}
