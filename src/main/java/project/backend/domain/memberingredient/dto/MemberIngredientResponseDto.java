package project.backend.domain.memberingredient.dto;
import lombok.*;
import project.backend.domain.ingredient.dto.IngredientResponseDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberIngredientResponseDto {
    public Long id;
    public Integer cnt;
    public LocalDateTime expDt;
    public IngredientResponseDto ingredient;
    public LocalDateTime createdDate;
    public LocalDateTime updatedDate;
}