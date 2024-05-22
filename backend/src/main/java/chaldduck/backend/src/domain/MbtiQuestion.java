package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MbtiQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "kind", nullable = false)
    private String kind;
}
