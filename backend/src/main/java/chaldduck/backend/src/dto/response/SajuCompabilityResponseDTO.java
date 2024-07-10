package chaldduck.backend.src.dto.response;

import chaldduck.backend.src.domain.SajuCompatibilityData;
import lombok.Getter;

@Getter
public class SajuCompabilityResponseDTO {
    private String sajuDescription;
    private String sajuImg;

    public static SajuCompabilityResponseDTO of(SajuCompatibilityData s) {
        SajuCompabilityResponseDTO response = new SajuCompabilityResponseDTO();
        response.sajuDescription = s.getDescription();
        response.sajuImg = s.getImage();
        return response;
    }
}
