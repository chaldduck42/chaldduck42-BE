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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private Saju saju;

    @Column(name = "birth", nullable = false)
    private String birth;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "mbti", nullable = false)
    private String mbti;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "sex")
    private String sex;

    public void updateMbti(String mbti) {
        this.mbti = mbti;
    }

}
