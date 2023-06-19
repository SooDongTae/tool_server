package tool.tool.domain.group_buying.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import tool.tool.domain.group_buying.domain.GroupBuying;
import tool.tool.domain.group_buying.domain.type.Category;
import tool.tool.domain.group_buying.domain.type.Status;
import tool.tool.domain.user.domain.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GroupBuyingRequest {

    @Builder
    public record GroupBuyingCreateRequest(
            @NotBlank
            @Size(min = 1, max = 20)
            String title,

            @Min(1)
            int maxPeople,

            @NotBlank
            String content,

            @NotBlank
            String untilAt,

            @NotBlank
            String category,

            @Min(0)
            int cost,

            @NotBlank
            String bank,

            String account
    ) {
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

}
