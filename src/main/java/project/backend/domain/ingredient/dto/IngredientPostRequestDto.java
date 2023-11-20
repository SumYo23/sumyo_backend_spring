package project.backend.domain.ingredient.dto;

import lombok.*;
import project.backend.domain.ingredient.entity.Ingredient;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientPostRequestDto {
    private String name;
    private Integer expPeriod;


    /**
     * Ingredient 엔티티 반환
     * @return
     */
    public Ingredient toEntity(){
        return Ingredient.builder()
                .name(this.name)
                .build();

    }
}