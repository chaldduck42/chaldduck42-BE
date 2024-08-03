package chaldduck.backend.src.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersInfoRequestDTO {
    private String nickname;
    private String birth;

}
