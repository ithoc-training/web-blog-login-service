package training.webblog.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseBody> login(@RequestBody LoginRequestBody loginRequestBody) {

        Boolean check = loginService.check(loginRequestBody.getUsername(), loginRequestBody.getPassword());
        LoginResponseBody loginResponseBody = new LoginResponseBody();
        loginResponseBody.setValidUser(check);

        return ResponseEntity.ok().body(loginResponseBody);
    }

}
