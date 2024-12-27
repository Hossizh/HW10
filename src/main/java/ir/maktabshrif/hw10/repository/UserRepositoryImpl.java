package ir.maktabshrif.hw10.repository;

import ir.maktabshrif.hw10.exception.UserNotFoundException;
import ir.maktabshrif.hw10.model.User;
import ir.maktabshrif.hw10.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public void save(User user) {
        EntityManager em = JpaUtil.getEm();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public Optional<User> findUser(String username, String password)  {
        try {
            EntityManager em = JpaUtil.getEm();
            User user = em.createQuery
                            ("select u from User u where u.username = : username AND u.password = :password", User.class)
                    .setParameter("username",username)
                    .setParameter("password",password)
                    .getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e){
            throw new UserNotFoundException();
        }

    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        try {
            EntityManager em = JpaUtil.getEm();
            User user = em.createQuery
                            ("select u from User u where u.username = : username", User.class)
                    .setParameter("username",username)
                    .getSingleResult();
            return Optional.ofNullable(user);
        } catch (NoResultException e){
            throw new UserNotFoundException();
        }
    }

}
