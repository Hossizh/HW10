package ir.maktabshrif.hw10.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class UserDTO {
    @NotBlank
    @Size(min = 6 ,max = 20,message = "Username must be between 4 and 20 characters")
    private String username;
    @NotBlank
    @Size(min = 6,message = "password must be at least 6 characters")
    private String password;
}
