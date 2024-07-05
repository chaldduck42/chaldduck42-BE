package chaldduck.backend.src.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MbtiResultRequestDTO {

    private String type;
    private int score;
}
