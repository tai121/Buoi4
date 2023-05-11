package ltjava.buoi4.survice;

import jakarta.transaction.Transactional;
import ltjava.buoi4.model.Product;
import ltjava.buoi4.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(int ID){
        return productRepository.findById(ID).get();
    }
}
