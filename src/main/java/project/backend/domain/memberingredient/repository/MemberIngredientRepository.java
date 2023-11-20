package project.backend.domain.memberingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.backend.domain.memberingredient.entity.MemberIngredient;

public interface MemberIngredientRepository extends JpaRepository<MemberIngredient, Long> {
}
