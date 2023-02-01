package examm.repository.repositoryImpl;

import examm.config.HibernateConfig;
import examm.model.User;
import examm.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 * The golden boy
 */
public class UserRepositoryImpl implements UserRepository {
    EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    @Override
    public String save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Successfully saved!!";
    }

    @Override
    public User getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public User updateById(Long id, User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setFullName(newUser.getFullName());
        user.setDateOfBirth(newUser.getDateOfBirth());
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
