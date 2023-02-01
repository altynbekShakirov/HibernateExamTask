package examm.repository.repositoryImpl;

import examm.config.HibernateConfig;
import examm.model.Instagram_account;
import examm.model.User;
import examm.repository.InstagramAccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;

/**
 * The golden boy
 */
public class InstagramAccountRepositoryImpl implements InstagramAccountRepository {
    EntityManagerFactory entityManagerFactory = HibernateConfig.createEntityManagerFactory();
    @Override
    public String save(Instagram_account instagramAccount, Long userId) {
        try{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        instagramAccount.setUser(user);
        entityManager.persist(instagramAccount);
        entityManager.getTransaction().commit();
        entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return "Successfully saved!!";
    }

    @Override
    public Instagram_account getById(Long id) {

        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Instagram_account instagramAccount1 = entityManager.find(Instagram_account.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instagramAccount1;

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Boolean existByEmail(String login) {
        try {
            String query = """
                select case
                 when count (i) > 0
                 then true 
                 else false
                 end 
                 from Instagram_account i
                 where
                 i.login = :newLogin 
                """;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Boolean trueOrFalse = entityManager.createQuery(query, Boolean.class)
                .setParameter("newLogin", login)
                .getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();;

        return trueOrFalse;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String changePassport(Long id, String changePassport) {
        try {


            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Instagram_account instagramAccount = entityManager.find(Instagram_account.class, id);
            instagramAccount.setPassword(changePassport);

            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully changed!!!";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public Instagram_account updateById(Long id, Instagram_account newInstagramAccount) {
        try {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Instagram_account instagramAccount = entityManager.find(Instagram_account.class, id);
        instagramAccount.setLogin(newInstagramAccount.getLogin());
        instagramAccount.setUserName(newInstagramAccount.getUserName());
        instagramAccount.setPassword(newInstagramAccount.getPassword());
        entityManager.getTransaction().commit();
        entityManager.close();
        return instagramAccount;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
