package examm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

/**
 * The golden boy
 */
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Instagram_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String login;
    private String password;
    @OneToOne(cascade = {MERGE, REFRESH, DETACH, PERSIST})
    private User user;
    @OneToMany(mappedBy = "instagram_account", cascade = ALL)
    private List<Post>posts;

    public Instagram_account(String userName, String login, String password ) {
        this.userName = userName;
        this.login = login;
        this.password = password;

    }

    @Override
    public String toString() {
        return "Instagram_account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
