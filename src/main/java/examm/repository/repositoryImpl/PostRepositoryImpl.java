package examm.repository.repositoryImpl;

import examm.config.HibernateConfig;
import examm.model.Instagram_account;
import examm.model.Post;
import examm.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.*;

/**
 * The golden boy
 */
public class PostRepositoryImpl  implements PostRepository {
    EntityManagerFactory entityManagerFactory= HibernateConfig.createEntityManagerFactory();


    @Override
    public String save(Post post,Long instagramId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Instagram_account instagramAccount = entityManager.find(Instagram_account.class, instagramId);
        post.setInstagram_account(instagramAccount);
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!!";
    }

    @Override
    public Post getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return post;
    }
    @Override
    public Post updateById(Long id, Post newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        post.setDescription(newPost.getDescription());
        post.setImage(newPost.getImage());
        post.setPublicationData(newPost.getPublicationData());
        entityManager.getTransaction().commit();
        entityManager.close();


        return post;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public String editDescription(Long id, String editDescription) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Post post = entityManager.find(Post.class, id);
        post.setDescription(editDescription);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully edited!!";
    }
}
