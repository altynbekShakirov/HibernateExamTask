package examm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The golden boy
 */
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "full_name")
    private String  fullName;
    @Column(name = "date_of_birth")
    private  String dateOfBirth;
    @OneToOne(mappedBy ="user", cascade = CascadeType.ALL)
    Instagram_account instagramAccount;

    public User(String fullName, String dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
