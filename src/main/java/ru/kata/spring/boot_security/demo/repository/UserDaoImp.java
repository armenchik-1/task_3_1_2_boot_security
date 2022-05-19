package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.createQuery(
                "select u from User u where u.id =:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getByUsername(String username) {
        return entityManager.createQuery(
                        "select u from User u where u.username =:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }


}
