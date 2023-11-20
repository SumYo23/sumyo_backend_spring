package project.backend.domain.ingredient.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.backend.domain.ingredient.dto.IngredientPatchRequestDto;
import project.backend.domain.common.entity.BaseEntity;
import project.backend.domain.memberingredient.entity.MemberIngredient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "exp_period")
    public Integer expPeriod;

    @OneToMany(mappedBy = "ingredient", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<MemberIngredient> memberIngredientList = new ArrayList<>();

    @Builder
    public Ingredient(String name){
        this.name = name;
        this.expPeriod = 0;
    }

    // Patch
    public Ingredient patchIngredient(IngredientPatchRequestDto ingredientPatchRequestDto){
        this.name = Optional.ofNullable(ingredientPatchRequestDto.getName()).orElse(this.name);
        this.expPeriod = (ingredientPatchRequestDto.getExpPeriod()!= null) ? ingredientPatchRequestDto.getExpPeriod() : this.expPeriod;
        return this;
    }
}
