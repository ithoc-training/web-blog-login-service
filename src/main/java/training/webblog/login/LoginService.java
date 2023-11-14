package training.webblog.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Value("${hash.salt.userPassword}")
    private String salt;

    private final BlogUserRepository blogUserRepository;

    public LoginService(BlogUserRepository blogUserRepository) {
        this.blogUserRepository = blogUserRepository;
    }

    public Boolean check(String username, String password) {

        BlogUserEntity blogUserEntity = blogUserRepository.findByUsername(username);
        if(blogUserEntity == null) {
            return Boolean.FALSE;
        }
        UserBo userBo = map(blogUserEntity);

        String hashedPassword = BCrypt.hashpw(password, salt);

        return userBo.checkPassword(hashedPassword);
    }

    public UserBo map(BlogUserEntity blogUserEntity) {

        UserBo userBo = new UserBo();
        userBo.setUsername(blogUserEntity.getUsername());
        userBo.setPassword(blogUserEntity.getPassword());

        return userBo;
    }

}
