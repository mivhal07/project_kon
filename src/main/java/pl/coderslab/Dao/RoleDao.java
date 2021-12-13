package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Role> getAllRoles() {
        return entityManager.createQuery("select  b from Role b").getResultList();
    }
}
