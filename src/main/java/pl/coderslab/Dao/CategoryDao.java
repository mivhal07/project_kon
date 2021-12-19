package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Category> categoryList() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }



    public void addCategory(Category category) {
        entityManager.persist(category);
    }
}
