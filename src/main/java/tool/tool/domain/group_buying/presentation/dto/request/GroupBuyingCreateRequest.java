package tool.tool.domain.group_buying.presentation.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GroupBuyingCreateRequest {
    @NotNull
    @Min(0)
    private Long leaderId;

    @NotBlank
    @Size(min = 1, max = 20)
    private String title;

    @Min(1)
    private int maxPeople;

    @NotBlank
    private String content;

    @NotBlank
    private String untilAt;

    @NotBlank
    private String category;

    @Min(0)
    private int cost;

    @NotBlank
    private String bank;

    @NotBlank
    private String account;

}
