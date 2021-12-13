package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Product;
import pl.coderslab.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }
}
