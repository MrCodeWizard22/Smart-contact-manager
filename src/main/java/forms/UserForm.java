package forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserForm {
    private String username;
    private String password;
    private String email;
    // private String firstName;
    // private String lastName;
    private String phoneNumber; // Assuming User class has this field
    // private String address; // Assuming User class has this field
    private String about;
}
