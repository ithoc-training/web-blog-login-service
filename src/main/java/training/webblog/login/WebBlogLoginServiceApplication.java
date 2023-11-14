package training.webblog.login;

import jakarta.annotation.PostConstruct;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBlogLoginServiceApplication {

    @Value("${hash.salt.userPassword}")
    private String salt;

    private final BlogRoleRepository blogRoleRepository;
    private final BlogUserRepository blogUserRepository;

    public WebBlogLoginServiceApplication(BlogRoleRepository blogRoleRepository, BlogUserRepository blogUserRepository) {
        this.blogRoleRepository = blogRoleRepository;
        this.blogUserRepository = blogUserRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebBlogLoginServiceApplication.class, args);
    }

    @PostConstruct
    private void init() {
        BlogRoleEntity visitor = new BlogRoleEntity();
        visitor.setName("Visitor");
        blogRoleRepository.save(visitor);

        BlogRoleEntity blogger = new BlogRoleEntity();
        blogger.setName("Blogger");
        blogRoleRepository.save(blogger);

        BlogRoleEntity admin = new BlogRoleEntity();
        admin.setName("Admin");
        blogRoleRepository.save(admin);

        BlogUserEntity shyVisitor = new BlogUserEntity();
        shyVisitor.setUsername("shy.visitor");
        shyVisitor.setPassword(BCrypt.hashpw("shy.visitor", salt));
        shyVisitor.setRole(visitor);
        blogUserRepository.save(shyVisitor);

        BlogUserEntity heavyBlogger = new BlogUserEntity();
        heavyBlogger.setUsername("heavy.blogger");
        heavyBlogger.setPassword(BCrypt.hashpw("heavy.blogger", salt));
        heavyBlogger.setRole(blogger);
        blogUserRepository.save(heavyBlogger);

        BlogUserEntity busyAdmin = new BlogUserEntity();
        busyAdmin.setUsername("busy.admin");
        busyAdmin.setPassword(BCrypt.hashpw("busy.admin", salt));
        busyAdmin.setRole(admin);
        blogUserRepository.save(busyAdmin);
    }

}
