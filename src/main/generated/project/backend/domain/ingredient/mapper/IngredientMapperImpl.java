package project.backend.domain.ingredient.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.backend.domain.ingredient.dto.IngredientPatchRequestDto;
import project.backend.domain.ingredient.dto.IngredientPostRequestDto;
import project.backend.domain.ingredient.dto.IngredientResponseDto;
import project.backend.domain.ingredient.dto.IngredientResponseDto.IngredientResponseDtoBuilder;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.ingredient.entity.Ingredient.IngredientBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-20T18:32:21+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public Ingredient ingredientPostRequestDtoToIngredient(IngredientPostRequestDto ingredientPostRequestDto) {
        if ( ingredientPostRequestDto == null ) {
            return null;
        }

        IngredientBuilder ingredient = Ingredient.builder();

        ingredient.name( ingredientPostRequestDto.getName() );
        if ( ingredientPostRequestDto.getExpPeriod() != null ) {
            ingredient.expPeriod( ingredientPostRequestDto.getExpPeriod() );
        }

        return ingredient.build();
    }

    @Override
    public Ingredient ingredientPatchRequestDtoToIngredient(IngredientPatchRequestDto ingredientPatchRequestDto) {
        if ( ingredientPatchRequestDto == null ) {
            return null;
        }

        IngredientBuilder ingredient = Ingredient.builder();

        ingredient.name( ingredientPatchRequestDto.getName() );
        if ( ingredientPatchRequestDto.getExpPeriod() != null ) {
            ingredient.expPeriod( ingredientPatchRequestDto.getExpPeriod() );
        }

        return ingredient.build();
    }

    @Override
    public IngredientResponseDto ingredientToIngredientResponseDto(Ingredient ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        IngredientResponseDtoBuilder ingredientResponseDto = IngredientResponseDto.builder();

        ingredientResponseDto.name( ingredient.getName() );
        ingredientResponseDto.expPeriod( ingredient.getExpPeriod() );

        return ingredientResponseDto.build();
    }

    @Override
    public List<IngredientResponseDto> ingredientsToIngredientResponseDtos(List<Ingredient> ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        List<IngredientResponseDto> list = new ArrayList<IngredientResponseDto>( ingredient.size() );
        for ( Ingredient ingredient1 : ingredient ) {
            list.add( ingredientToIngredientResponseDto( ingredient1 ) );
        }

        return list;
    }
}
