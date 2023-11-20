package project.backend.domain.ingredient.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.backend.domain.ingredient.dto.IngredientPatchRequestDto;
import project.backend.domain.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "exp_period")
    public Integer expPeriod;

    @Builder
    public Ingredient(String name, int expPeriod){
        this.name = name;
        this.expPeriod = expPeriod;
    }

    // Patch
    public Ingredient patchIngredient(IngredientPatchRequestDto ingredientPatchRequestDto){
        this.name = Optional.ofNullable(ingredientPatchRequestDto.getName()).orElse(this.name);
        this.expPeriod = (ingredientPatchRequestDto.getExpPeriod()!= null) ? ingredientPatchRequestDto.getExpPeriod() : this.expPeriod;
        return this;
    }
}
