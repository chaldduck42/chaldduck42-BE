package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class SajuCompatabilityData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private Saju saju1;

    @OneToOne
    private Saju saju2;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;
}
