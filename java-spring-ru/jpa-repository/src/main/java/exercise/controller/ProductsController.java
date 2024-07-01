package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "")
    public List<Product> getProducts(@RequestParam(required = false, name = "min") Integer min,
                                     @RequestParam(required = false, name = "max") Integer max) {
        var sort = Sort.by(Sort.Order.asc("price"));
        if (min == null) {
            if (max == null) {
                return productRepository.findAll(sort);
            }
            else return productRepository.findByPriceLessThanEqual(max, sort);
        } else {
            if (max == null) {
                return productRepository.findByPriceGreaterThanEqual(min, sort);
            }
            else return productRepository.findByPriceBetween(min, max, sort);
        }
    }

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
