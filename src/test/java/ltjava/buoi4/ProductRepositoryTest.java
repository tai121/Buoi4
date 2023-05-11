package ltjava.buoi4;

import ltjava.buoi4.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void TestCreate(){
        Product product = new Product();
        product.setName("Non bao hiem");
        product.setBrand("Non Son");
        product.setPrice(1000000l);

        productRepository.save(product);
        Product selectProduct = testEntityManager.find(Product.class,product.getId());
        assertThat(product.getName()).isEqualTo(selectProduct.getName());
    }
}
