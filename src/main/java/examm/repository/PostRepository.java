package examm.repository;

import examm.model.Post;
import org.hibernate.sql.Update;

/**
 * The golden boy
 */
public interface PostRepository {
    String save(Post post,Long instagramId);
    Post getById(Long id);
    Post updateById(Long id,Post newPost);
    void deleteById(Long id);
    String  editDescription(Long id,String editDescription);

}
