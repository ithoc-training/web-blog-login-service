package training.webblog.login;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "blog_user")
@Setter
@Getter
public class BlogUserEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password; // encrypted

    @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne
    @JoinColumn(name = "blog_role_id")
    private BlogRoleEntity role;

}
