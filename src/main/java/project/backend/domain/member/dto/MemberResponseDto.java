package project.backend.domain.member.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    public Long id;
    public String nickname;
    public String profileUrl;
    public LocalDateTime createdDate;
    public LocalDateTime updatedDate;
}
