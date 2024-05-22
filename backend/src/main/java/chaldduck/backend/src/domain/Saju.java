package chaldduck.backend.src.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Saju {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fiveHang", nullable = false)
    private String fiveHang;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;
}
