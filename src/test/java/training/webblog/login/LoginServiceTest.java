package training.webblog.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginServiceTest {

    @Test
    void readUser() {
    }

    @Test
    void map() {

        // given
        LoginService loginService = new LoginService(null);
        BlogUserEntity blogUserEntity = new BlogUserEntity();
        blogUserEntity.setUsername("username");
        blogUserEntity.setPassword("password");

        // when
        UserBo userBo = loginService.map(blogUserEntity);

        // then
        Assertions.assertEquals("username", userBo.getUsername());
        Assertions.assertEquals("password", userBo.getPassword());

    }

}
