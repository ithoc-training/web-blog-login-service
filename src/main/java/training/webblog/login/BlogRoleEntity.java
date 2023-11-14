package training.webblog.login;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "blog_role")
@Setter
@Getter
public class BlogRoleEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
