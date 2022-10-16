package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAccountRegistrationModel {

    private String email;
    private String password;
    private String passwordConfirmation;
    private String passwordHint;
}
