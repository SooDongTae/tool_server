package tool.tool.domain.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tool.tool.domain.group_buying.domain.GroupBuying;

@Entity
@Getter
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_bank")
    private String accountBank;

    @Column(name = "account_num")
    private String accountNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    private GroupBuying groupBuying;

    protected Leader() {};

    @Builder
    public Leader(Long id, String accountBank, String accountNum, User user) {
        this.id = id;
        this.accountBank = accountBank;
        this.accountNum = accountNum;
        this.user = user;
    }

    public void setUser(User user) {
        if(this.user != null) {
            this.user.getLeaders().remove(this);
        }
        this.user = user;
        user.getLeaders().add(this);
    }

    public void setGroupBuying(GroupBuying groupBuying) {
        this.groupBuying = groupBuying;
    }
}
