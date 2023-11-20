package project.backend.domain.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.backend.domain.ingredient.entity.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findOneByName(String name);
}
