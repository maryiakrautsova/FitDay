package testdata;

import models.NewAccountRegistrationModel;
import utils.FakeMessageGenerator;

public class PrepareNewAccountData {

    public static NewAccountRegistrationModel getValidRegistrationData(){
        String password = FakeMessageGenerator.generatePassword();
        return NewAccountRegistrationModel.
                builder().
                email(FakeMessageGenerator.generateEmail()).
                password(password).
                passwordConfirmation(password).
                passwordHint(FakeMessageGenerator.generatePasswordHint()).
                build();
    }
}
