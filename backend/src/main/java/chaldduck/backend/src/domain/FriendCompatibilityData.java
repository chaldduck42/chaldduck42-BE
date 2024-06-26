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

    @OneToOne //friend(FK)-친구
    private Users friend;

    @ManyToOne //link_owner 링크의 주인
    private Users linkOwner;

    @OneToOne //mbti_result_id
    private MbtiCompatibilityData mbtiResultId;

    @OneToOne
    private SajuCompatibilityData sajuCompatability;




}
