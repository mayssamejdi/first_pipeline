package integration.controller;



import integration.entities.Category;
import integration.entities.Products;
import integration.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categ")
public class CategoriesController {

private  final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @PostMapping(path = "/add")
    public Category addCategory(@RequestBody Category category) {

        return categoriesService.addCategory(category);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Category> getAllCategory() {


          return categoriesService.getAll();
        }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){

        return categoriesService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {

        categoriesService.delete(id);
    }
    @PutMapping(path="{id}/update")
    public Category updateCategory(@RequestBody Category category,@PathVariable long id){
        return categoriesService.updateCategory(id,category);
    }


}