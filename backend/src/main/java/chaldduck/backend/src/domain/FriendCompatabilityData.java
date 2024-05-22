package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class FriendCompatabilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne //friend(FK)-친구
    private User friend;

    @ManyToOne //link_owner 링크의 주인
    private User user;

    @OneToOne //mbti_result_id
    private MbtiCompatibilityData mbtiCompatibilityData;

    @OneToOne
    private SajuCompatabilityData sajuCompatabilityData;




}
