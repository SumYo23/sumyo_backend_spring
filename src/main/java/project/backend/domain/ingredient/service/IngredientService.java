package project.backend.domain.ingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.domain.ingredient.dto.IngredientPatchRequestDto;
import project.backend.domain.ingredient.dto.IngredientPostRequestDto;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.ingredient.mapper.IngredientMapper;
import project.backend.domain.ingredient.repository.IngredientRepository;
import project.backend.global.error.exception.BusinessException;
import project.backend.global.error.exception.ErrorCode;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public Ingredient createIngredient(IngredientPostRequestDto ingredientPostRequestDto){
        Ingredient ingredient = Ingredient.builder()
                .name(ingredientPostRequestDto.getName()).build();
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    public Ingredient getIngredient(Long id) {
        return verifiedIngredient(id);
    }

    public Ingredient getOrCreateIngredient(String name) {
        return ingredientRepository.findOneByName(name).orElseGet(() -> createIngredient(IngredientPostRequestDto.builder().name(name).build()));
    }

    public List<Ingredient> getIngredientList() {
        return ingredientRepository.findAll();
    }

    public Ingredient patchIngredient(Long id, IngredientPatchRequestDto ingredientPatchRequestDto) {
        Ingredient ingredient = verifiedIngredient(id).patchIngredient(ingredientPatchRequestDto);
        ingredientRepository.save(ingredient);
        return ingredient;
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.delete(verifiedIngredient(id));
    }

    public Ingredient verifiedIngredientName(String name) {
        return ingredientRepository.findOneByName(name).orElseThrow(() -> new BusinessException(ErrorCode.INGREDIENT_NOT_FOUND));
    }

    private Ingredient verifiedIngredient(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.INGREDIENT_NOT_FOUND));
    }

}
