package project.backend.domain.memberingredient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.ingredient.service.IngredientService;
import project.backend.domain.jwt.service.JwtService;
import project.backend.domain.member.entity.Member;
import project.backend.domain.memberingredient.dto.MemberIngredientPatchRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientPostRequestDto;
import project.backend.domain.memberingredient.entity.MemberIngredient;
import project.backend.domain.memberingredient.mapper.MemberIngredientMapper;
import project.backend.domain.memberingredient.repository.MemberIngredientRepository;
import project.backend.global.error.exception.BusinessException;
import project.backend.global.error.exception.ErrorCode;
import project.backend.global.validator.LocalDateTimeValidation;
import static project.backend.global.validator.LocalDateTimeValidation.convertStringToLocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberIngredientService {
    private final MemberIngredientRepository memberIngredientRepository;
    private final MemberIngredientMapper memberIngredientMapper;
    private final IngredientService ingredientService;
    private final JwtService jwtService;

    public MemberIngredient createMemberIngredient(Member member, MemberIngredientPostRequestDto memberIngredientPostRequestDto){

        MemberIngredient memberIngredient = MemberIngredient.builder()
                .cnt(memberIngredientPostRequestDto.getCnt())
                .expDt(convertStringToLocalDateTime(memberIngredientPostRequestDto.getExpDt())).build();
        Ingredient ingredient = ingredientService.getOrCreateIngredient(memberIngredientPostRequestDto.getIngredientName());
        memberIngredient.setMemberIngredient(member, ingredient);
        memberIngredientRepository.save(memberIngredient);
        return memberIngredient;
    }

    public MemberIngredient getMemberIngredient(Long id) {
        return verifiedMemberIngredient(id);
    }

    public List<MemberIngredient> getMemberIngredientByAccessToken(String accessToken) {
        return jwtService.getMemberFromAccessToken(accessToken).getMemberIngredientList();
    }

    public List<MemberIngredient> getMemberIngredientList() {
        return memberIngredientRepository.findAll();
    }

    public MemberIngredient editMemberIngredient(Long id, String accessToken, MemberIngredientPatchRequestDto memberIngredientPatchRequestDto){

        MemberIngredient memberIngredient = verifiedMemberIngredient(id);
        Member member = jwtService.getMemberFromAccessToken(accessToken);
        if (memberIngredient.getMember() == member) {
            memberIngredient.patchMemberIngredient(memberIngredientPatchRequestDto);
            memberIngredientRepository.save(memberIngredient);
        } else {
            throw new BusinessException(ErrorCode.MEMBER_INGREDIENT_CANT_DELETE);
        }
        return memberIngredient;
    }

    public void deleteMemberIngredient(String accessToken, Long id) {
        MemberIngredient memberIngredient = verifiedMemberIngredient(id);
        Member member = jwtService.getMemberFromAccessToken(accessToken);
        if (memberIngredient.getMember() == member) {
            memberIngredientRepository.delete(verifiedMemberIngredient(id));
        } else {
            throw new BusinessException(ErrorCode.MEMBER_INGREDIENT_CANT_DELETE);
        }
    }

    private MemberIngredient verifiedMemberIngredient(Long id) {
        return memberIngredientRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_INGREDIENT_NOT_FOUND));
    }

}
