package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MbtiAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    private MbtiQuestion mbtiQuestion;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "score", nullable = false)
    private int score;

}
