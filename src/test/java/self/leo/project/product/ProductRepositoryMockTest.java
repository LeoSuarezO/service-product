package self.leo.project.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import self.leo.project.product.entity.Category;
import self.leo.project.product.entity.Product;
import self.leo.project.product.repository.ProductRepository;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void returnListProduct(){
        Product productOne = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("Lenovo 12 RAM")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("19986"))
                .status("")
                .createDate(new Date()).build();
        productRepository.save(productOne);

        List<Product> found = productRepository.findByCategory(productOne.getCategory());
        System.out.println(found.size());
        Assertions.assertThat(found.size()).isEqualTo(3);

    }
}
