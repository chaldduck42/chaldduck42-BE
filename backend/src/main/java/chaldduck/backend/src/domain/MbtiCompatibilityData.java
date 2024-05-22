package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MbtiCompatibilityData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mbti_1", nullable = false)
    private String mbti_1;

    @Column(name = "mbti_2", nullable = false)
    private String mbti_2;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;
}
