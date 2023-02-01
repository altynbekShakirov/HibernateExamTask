package examm.service.servece;

import examm.model.Post;
import examm.repository.PostRepository;
import examm.repository.repositoryImpl.PostRepositoryImpl;
import examm.service.PostService;

/**
 * The golden boy
 */
public class PostServiceImpl implements PostService {
    PostRepository postRepository = new PostRepositoryImpl();
    @Override
    public String save(Post post,Long instagramId) {
        return postRepository.save(post,instagramId);
    }

    @Override
    public Post getById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public Post updateById(Long id, Post newPost) {
        return postRepository.updateById(id,newPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);


    }

    @Override
    public String editDescription(Long id, String editDescription) {
        return postRepository.editDescription(id,editDescription);
    }
}
