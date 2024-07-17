package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.Saju;
import lombok.Getter;

@Getter
public class SajuResultResponseDTO {
    private String fiveHang;
    private String image;
    private String description;

    public static SajuResultResponseDTO of(Saju saju) {
        SajuResultResponseDTO response = new SajuResultResponseDTO();
        response.fiveHang = saju.getFiveHang();
        response.image = saju.getImage();
        response.description = saju.getDescription();
        return response;
    }

}
