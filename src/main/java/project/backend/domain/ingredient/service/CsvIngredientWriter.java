package project.backend.domain.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import project.backend.domain.ingredient.dto.IngredientPostRequestDto;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.ingredient.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvIngredientWriter implements ItemWriter<IngredientPostRequestDto> {

    private final IngredientRepository ingredientRepository;

    @Override
    public void write(List<? extends IngredientPostRequestDto> items) throws Exception {
        List<Ingredient> ingredientList = new ArrayList<>();

        items.forEach(getIngredientDto -> {
            Ingredient ingredient = getIngredientDto.toEntity();
            ingredientList.add(ingredient);
        });

        ingredientRepository.saveAll(ingredientList);

    }
}