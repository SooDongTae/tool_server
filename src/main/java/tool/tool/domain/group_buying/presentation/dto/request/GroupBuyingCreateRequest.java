package tool.tool.domain.group_buying.presentation.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;
import tool.tool.domain.user.domain.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class GroupBuyingCreateRequest {

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

    public GroupBuying toEntity(User user) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return  GroupBuying.builder()
                .title(this.title)
                .maxPeople(this.maxPeople)
                .content(this.content)
                .cost(this.cost)
                .category(Category.valueOf(this.category))
                .status(Status.ACTIVATED)
                .user(user)
                .untilAt(LocalDateTime.parse(this.untilAt + " 00:00:00.000", dateTimeFormatter))
                .ownerAccount(this.account)
                .ownerBank(this.bank)
                .build();
    }

}
