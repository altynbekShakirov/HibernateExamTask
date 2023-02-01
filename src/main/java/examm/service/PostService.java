package examm.service;

import examm.model.Post;

/**
 * The golden boy
 */
public interface PostService {
    String save(Post post,Long instagramId);
    Post getById(Long id);
    Post updateById(Long id,Post newPost);
    void deleteById(Long id);
   String editDescription(Long id,String editDescription);

}
