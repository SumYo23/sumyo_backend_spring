package project.backend.domain.memberingredient.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.backend.domain.common.entity.BaseEntity;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.member.entity.Member;
import project.backend.domain.memberingredient.dto.MemberIngredientPatchRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static project.backend.global.validator.LocalDateTimeValidation.convertStringToLocalDateTime;

@Entity(name="member_ingredient")
@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberIngredient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_ingredient_id")
    public Long id;

    @Column(name = "cnt")
    public Integer cnt;

    @Column(name = "exp_dt")
    public LocalDateTime expDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    public Ingredient ingredient;

    @Builder
    public MemberIngredient(Integer cnt, LocalDateTime expDt){
        this.cnt = cnt;
        this.expDt = expDt;
    }

    // Patch
    public MemberIngredient patchMemberIngredient(MemberIngredientPatchRequestDto memberIngredientPatchRequestDto){
        this.cnt = Optional.ofNullable(memberIngredientPatchRequestDto.getCnt()).orElse(this.cnt);
        this.expDt = Optional.ofNullable(convertStringToLocalDateTime(memberIngredientPatchRequestDto.getExpDt())).orElse(this.expDt);
        return this;
    }

    // == 연관관계 매핑 == //
    public void setMemberIngredient(Member member, Ingredient ingredient) {
        if (this.member != null) {
            if (this.member.getMemberIngredientList().contains(this)) {
                this.member.getMemberIngredientList().remove(this);
            }
        }
        if (this.ingredient != null) {
            if (this.ingredient.getMemberIngredientList().contains(this)) {
                this.ingredient.getMemberIngredientList().remove(this);
            }
        }
        this.member = Optional.ofNullable(member).orElse(this.member);
        this.member.getMemberIngredientList().add(this);
        this.ingredient = Optional.ofNullable(ingredient).orElse(this.ingredient);
        this.ingredient.getMemberIngredientList().add(this);
    }
}
