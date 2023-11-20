package project.backend.domain.ingredient.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientPatchRequestDto {
    private String name;
    private Integer expPeriod;
}