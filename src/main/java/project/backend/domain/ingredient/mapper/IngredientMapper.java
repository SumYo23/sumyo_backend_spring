package project.backend.domain.ingredient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import project.backend.domain.ingredient.dto.IngredientPatchRequestDto;
import project.backend.domain.ingredient.dto.IngredientPostRequestDto;
import project.backend.domain.ingredient.dto.IngredientResponseDto;
import project.backend.domain.ingredient.entity.Ingredient;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {
    Ingredient ingredientPostRequestDtoToIngredient(IngredientPostRequestDto ingredientPostRequestDto);

    Ingredient ingredientPatchRequestDtoToIngredient(IngredientPatchRequestDto ingredientPatchRequestDto);

    IngredientResponseDto ingredientToIngredientResponseDto(Ingredient ingredient);

    List<IngredientResponseDto> ingredientsToIngredientResponseDtos(List<Ingredient> ingredient);
}
