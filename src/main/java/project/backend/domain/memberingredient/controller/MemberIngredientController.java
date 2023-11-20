package project.backend.domain.memberingredient.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import project.backend.domain.jwt.service.JwtService;
import project.backend.domain.memberingredient.dto.MemberIngredientPatchRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientPostRequestDto;
import project.backend.domain.memberingredient.dto.MemberIngredientResponseDto;
import project.backend.domain.memberingredient.entity.MemberIngredient;
import project.backend.domain.memberingredient.mapper.MemberIngredientMapper;
import project.backend.domain.memberingredient.service.MemberIngredientService;
import project.backend.global.error.exception.BusinessException;
import project.backend.global.error.exception.ErrorCode;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "재료 추가 API - 완료 API(프론트 작업 가능)")
@RestController
@RequestMapping("/api/member/ingredients")
@RequiredArgsConstructor
public class MemberIngredientController {

    private final MemberIngredientService memberIngredientService;
    private final MemberIngredientMapper memberIngredientMapper;
    private final JwtService jwtService;

    @ApiOperation(value = "나의 재료 추가",
            notes = " - header \"Authorization\" : accessToken입력(필수)\n" +
                " - reqeust : {\n" +
                "  \"cnt\": 5(1이상),\n" +
                "  \"expDt\": \"2023-10-10T10:10:10(필수)\",\n" +
                "  \"ingredientName\": \"사과(필수)\"\n" +
                "}\n" +
                " - ingredientName 추가시 /api/ingredients를 조회 후 사용자에게 자동완성으로 권장한 후에 입력해주세요.")
    @PostMapping
    public ResponseEntity postMemberIngredient(
            @RequestHeader(value = "Authorization", required = false) String accessToken,
            @RequestBody(required = false) MemberIngredientPostRequestDto memberIngredientPostRequestDto) {
        if (ObjectUtils.isEmpty(memberIngredientPostRequestDto) || ObjectUtils.isEmpty(accessToken)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        }
        MemberIngredient memberIngredient = memberIngredientService.createMemberIngredient(
                jwtService.getMemberFromAccessToken(accessToken),
                memberIngredientPostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberIngredientMapper.memberIngredientToMemberIngredientResponseDto(memberIngredient));
    }

    @ApiOperation(value = "나의 재료 목록", notes = " - header \"Authorization\" : accessToken입력(필수)\n")
    @GetMapping
    public ResponseEntity getMemberIngredient(
            @RequestHeader(value = "Authorization", required = false) String accessToken) {
        if (ObjectUtils.isEmpty(accessToken)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        }
        List<MemberIngredient> memberIngredientList = memberIngredientService.getMemberIngredientByAccessToken(accessToken);
        List<MemberIngredientResponseDto> memberIngredientResponseDtoList = memberIngredientMapper.memberIngredientsToMemberIngredientResponseDtos(memberIngredientList);
        return ResponseEntity.status(HttpStatus.OK).body(memberIngredientResponseDtoList);
    }
    @ApiOperation(value = "나의 재료 수정",
            notes = " - header \"Authorization\" : accessToken입력(필수)\n" +
                    " - member-ingredient-id : 사용자 재료 id(필수)\n" +
                    " - reqeust : {\n" +
                    "  \"cnt\": 5(1이상, 선택),\n" +
                    "  \"expDt\": \"2023-10-10T10:10:10(선택)\",\n" +
                    "}")
    @PatchMapping("/{memberIngredientId}")
    public ResponseEntity editMemberIngredient(
            @PathVariable(required = false) Long memberIngredientId,
            @RequestBody(required = false) MemberIngredientPatchRequestDto memberIngredientPatchRequestDto,
            @RequestHeader(value = "Authorization", required = false) String accessToken) {

        if (ObjectUtils.isEmpty(memberIngredientId)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        } else if (ObjectUtils.isEmpty(memberIngredientPatchRequestDto)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        } else if (ObjectUtils.isEmpty(accessToken)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        }

        MemberIngredient memberIngredient = memberIngredientService.editMemberIngredient(memberIngredientId, accessToken, memberIngredientPatchRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(memberIngredientMapper.memberIngredientToMemberIngredientResponseDto(memberIngredient));
    }

    @ApiOperation(value = "나의 재료 삭제",
            notes = " - header \"Authorization\" : accessToken입력(필수)\n" +
            " - member-ingredient-id : 사용자 재료 id(필수)")
    @DeleteMapping("/{member-ingredient-id}")
    public ResponseEntity deleteMemberIngredient(
            @PathVariable(value = "member-ingredient-id", required = false) Long memberIngredientId,
            @RequestHeader(value = "Authorization", required = false) String accessToken) {

        if (ObjectUtils.isEmpty(memberIngredientId)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        } else if (ObjectUtils.isEmpty(accessToken)) {
            throw new BusinessException(ErrorCode.MISSING_REQUEST);
        }
        memberIngredientService.deleteMemberIngredient(accessToken, memberIngredientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
