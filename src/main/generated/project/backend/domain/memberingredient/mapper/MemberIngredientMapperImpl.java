package project.backend.domain.memberingredient.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.backend.domain.ingredient.dto.IngredientResponseDto;
import project.backend.domain.ingredient.dto.IngredientResponseDto.IngredientResponseDtoBuilder;
import project.backend.domain.ingredient.entity.Ingredient;
import project.backend.domain.memberingredient.dto.MemberIngredientPatchRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientPostRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientResponseDto;
import project.backend.domain.memberingredient.dto.MemberIngredientResponseDto.MemberIngredientResponseDtoBuilder;
import project.backend.domain.memberingredient.entity.MemberIngredient;
import project.backend.domain.memberingredient.entity.MemberIngredient.MemberIngredientBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-20T22:15:31+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 11.0.16.1 (Oracle Corporation)"
)
@Component
public class MemberIngredientMapperImpl implements MemberIngredientMapper {

    @Override
    public MemberIngredient memberIngredientPostRequestDtoToMemberIngredient(MemberIngredientPostRequestDto memberIngredientPostRequestDto) {
        if ( memberIngredientPostRequestDto == null ) {
            return null;
        }

        MemberIngredientBuilder memberIngredient = MemberIngredient.builder();

        memberIngredient.cnt( memberIngredientPostRequestDto.getCnt() );
        if ( memberIngredientPostRequestDto.getExpDt() != null ) {
            memberIngredient.expDt( LocalDateTime.parse( memberIngredientPostRequestDto.getExpDt() ) );
        }

        return memberIngredient.build();
    }

    @Override
    public MemberIngredient memberIngredientPatchRequestDtoToMemberIngredient(MemberIngredientPatchRequestDto memberIngredientPatchRequestDto) {
        if ( memberIngredientPatchRequestDto == null ) {
            return null;
        }

        MemberIngredientBuilder memberIngredient = MemberIngredient.builder();

        memberIngredient.cnt( memberIngredientPatchRequestDto.getCnt() );
        if ( memberIngredientPatchRequestDto.getExpDt() != null ) {
            memberIngredient.expDt( LocalDateTime.parse( memberIngredientPatchRequestDto.getExpDt() ) );
        }

        return memberIngredient.build();
    }

    @Override
    public MemberIngredientResponseDto memberIngredientToMemberIngredientResponseDto(MemberIngredient memberIngredient) {
        if ( memberIngredient == null ) {
            return null;
        }

        MemberIngredientResponseDtoBuilder memberIngredientResponseDto = MemberIngredientResponseDto.builder();

        memberIngredientResponseDto.id( memberIngredient.getId() );
        memberIngredientResponseDto.cnt( memberIngredient.getCnt() );
        memberIngredientResponseDto.expDt( memberIngredient.getExpDt() );
        memberIngredientResponseDto.ingredient( ingredientToIngredientResponseDto( memberIngredient.getIngredient() ) );
        memberIngredientResponseDto.createdDate( memberIngredient.getCreatedDate() );
        memberIngredientResponseDto.updatedDate( memberIngredient.getUpdatedDate() );

        return memberIngredientResponseDto.build();
    }

    @Override
    public List<MemberIngredientResponseDto> memberIngredientsToMemberIngredientResponseDtos(List<MemberIngredient> memberIngredient) {
        if ( memberIngredient == null ) {
            return null;
        }

        List<MemberIngredientResponseDto> list = new ArrayList<MemberIngredientResponseDto>( memberIngredient.size() );
        for ( MemberIngredient memberIngredient1 : memberIngredient ) {
            list.add( memberIngredientToMemberIngredientResponseDto( memberIngredient1 ) );
        }

        return list;
    }

    protected IngredientResponseDto ingredientToIngredientResponseDto(Ingredient ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        IngredientResponseDtoBuilder ingredientResponseDto = IngredientResponseDto.builder();

        ingredientResponseDto.name( ingredient.getName() );
        ingredientResponseDto.expPeriod( ingredient.getExpPeriod() );

        return ingredientResponseDto.build();
    }
}
