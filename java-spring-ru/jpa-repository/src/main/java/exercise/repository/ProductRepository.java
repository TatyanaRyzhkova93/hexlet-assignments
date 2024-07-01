package exercise.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceLessThanEqual(Integer startPrice, Sort sort);
    List<Product> findByPriceGreaterThanEqual(Integer endPrice, Sort sort);
    List<Product> findByPriceBetween(Integer startPrice, Integer endPrice, Sort sort);
}
