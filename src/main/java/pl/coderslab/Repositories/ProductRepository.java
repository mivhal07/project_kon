package pl.coderslab.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.Entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select pro from Product pro where pro.category.id=?1")
    List<Product> findProductByCategory(Long id);
}
