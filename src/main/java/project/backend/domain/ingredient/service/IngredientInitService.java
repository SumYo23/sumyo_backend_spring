package project.backend.domain.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.ingredient.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class IngredientInitService implements ApplicationRunner {

    private final IngredientRepository ingredientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(ingredientRepository.findAll().size() == 0) {

//            List<Ingredient> ingredientList = new ArrayList<>();
//
//            ingredientList.add(Ingredient.builder().name("시위").build());
//            ingredientList.add(Ingredient.builder().name("축제").build());
////            ingredientList.add(Ingredient.builder().name("자연재해").build());
//
//            ingredientRepository.saveAll(ingredientList);
        }
    }
}