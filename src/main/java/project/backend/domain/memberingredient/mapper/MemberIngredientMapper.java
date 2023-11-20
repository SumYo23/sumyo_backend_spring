package project.backend.domain.memberingredient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import project.backend.domain.memberingredient.dto.MemberIngredientPatchRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientPostRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientResponseDto;
import project.backend.domain.memberingredient.entity.MemberIngredient;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberIngredientMapper {
    MemberIngredient memberIngredientPostRequestDtoToMemberIngredient(MemberIngredientPostRequestDto memberIngredientPostRequestDto);

    MemberIngredient memberIngredientPatchRequestDtoToMemberIngredient(MemberIngredientPatchRequestDto memberIngredientPatchRequestDto);

    MemberIngredientResponseDto memberIngredientToMemberIngredientResponseDto(MemberIngredient memberIngredient);

    List<MemberIngredientResponseDto> memberIngredientsToMemberIngredientResponseDtos(List<MemberIngredient> memberIngredient);
}
