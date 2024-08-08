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
public class SajuCompatibilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "saju_1_id")
    private Saju saju1;

    @Column(name = "saju_1_sex")
    private String saju1Sex;

    @ManyToOne
    @JoinColumn(name = "saju_2_id")
    private Saju saju2;

    @Column(name = "saju_2_sex")
    private String saju2Sex;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "score", nullable = false)
    private int score;
}
