package integration.controller;


import integration.entities.Products;
import integration.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/prod")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {

        this.productsService = productsService;
    }

    @PostMapping(path = "/add/{id}")
    public void addProduct(@RequestBody Products products, @PathVariable Long id) {
    this.productsService.addProduct(products,id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Products> getAllProducts() {

        List<Products> productyList =productsService.getAllProducts();

        return productyList;

    }
    @DeleteMapping("{id}")
    public void deleteProducts(@PathVariable Long id) {

        productsService.deleteProduct(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Products products) {
        Optional<Products> products1 = productsService.findById(id);
        if (products1.isPresent()) {
            productsService.update(id, products);
        } else {
            productsService.addProduct(products,id);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    public  List <Products>getProductById(@PathVariable Long id){

        return productsService.findProduct(id);
    }

}
