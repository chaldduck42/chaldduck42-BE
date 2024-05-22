package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private Saju saju;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "mbti", nullable = false)
    private String mbti;
}
