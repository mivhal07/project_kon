package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    public List<Product> productList() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public List<Product> productListByKuchenne() {
        return entityManager.createQuery("select p from Product p where p.category.category_id=3").getResultList();
    }

    public List<Product> productListByBiżuteria() {
        return entityManager.createQuery("select pr from Product pr where pr.category.category_id=2").getResultList();
    }

    public List<Product> productListByDonice() {
        return entityManager.createQuery("select pro from Product pro where pro.category.category_id=1").getResultList();
    }

    public Product findProductById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void updateProduct(Product product){
        entityManager.merge(product);
    }


}
