package ir.ghazale.Personalwebapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.ghazale.Personalwebapi.model.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientsDto  {

    private Long clientId;

    private String firstname;

    private String lastname;

    private Gender gender;

    private String phoneNumber;

    @NotNull
    private String username;

    @NotNull
    private String password;

}
