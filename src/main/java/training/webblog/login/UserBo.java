package training.webblog.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBo {

    private String username;
    private String password;

    public Boolean checkPassword(String password) {

        return this.password.equals(password);
    }

}
