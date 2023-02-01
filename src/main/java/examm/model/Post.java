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
@Table(name ="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private String image;
    private  String description;
    @Column(name = "publication_Data")
    private String publicationData;
    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
    private Instagram_account instagram_account;

    public Post(String image, String description, String publicationData) {
        this.image = image;
        this.description = description;
        this.publicationData = publicationData;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", publicationData='" + publicationData + '\'' +
                '}';
    }
}
