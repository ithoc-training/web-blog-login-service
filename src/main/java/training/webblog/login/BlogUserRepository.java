package training.webblog.login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserRepository extends JpaRepository<BlogUserEntity, Long> {

    BlogUserEntity findByUsername(String username);

}
