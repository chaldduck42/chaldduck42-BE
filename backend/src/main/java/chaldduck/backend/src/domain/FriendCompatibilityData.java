package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendCompatibilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne   // friend_id 친구
    @JoinColumn(name = "friend_id")
    private Users friend;

    @ManyToOne   // link_owner 링크의 주인
    @JoinColumn(name = "link_owner_id")
    private Users linkOwner;

    @ManyToOne   // mbti 궁합
    @JoinColumn(name = "mbti_compatibility_id")
    private MbtiCompatibilityData mbtiCompatibility;

    @ManyToOne   // 사주 궁합
    @JoinColumn(name = "saju_result_id")
    private SajuCompatibilityData sajuCompatability;
}
