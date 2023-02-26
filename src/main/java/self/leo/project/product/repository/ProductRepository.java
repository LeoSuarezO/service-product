package self.leo.project.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import self.leo.project.product.entity.Category;
import self.leo.project.product.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);

}
