package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Category;

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

    public void editCat(Category category) {
        entityManager.merge(category);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
}
