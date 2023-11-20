package project.backend.domain.memberingredient.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberIngredientPostRequestDto {
    @NotBlank(message = "재료명을 입력해주세요.")
    public String ingredientName;
    @Min(value = 1, message = "0보다 큰 수량을 입력해주세요.")
    public Integer cnt;
    public String expDt;
}