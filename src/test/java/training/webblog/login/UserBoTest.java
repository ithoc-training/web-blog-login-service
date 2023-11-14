package training.webblog.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserBoTest {

    @Test
    void checkPassword() {

        // given
        UserBo userBo = new UserBo();
        userBo.setPassword("password");

        // when
        Boolean valid = userBo.checkPassword("password");

        // then
        Assertions.assertTrue(valid);
    }

    @Test
    void checkPasswordFailure() {

        // given
        UserBo userBo = new UserBo();
        userBo.setPassword("password");

        // when
        Boolean valid = userBo.checkPassword("p@ssw0rd");

        // then
        Assertions.assertFalse(valid);
    }

}
