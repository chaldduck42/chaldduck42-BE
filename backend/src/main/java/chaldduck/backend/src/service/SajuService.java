package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.Saju;
import chaldduck.backend.src.dto.response.SajuResultResponseDTO;
import chaldduck.backend.src.repository.SajuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SajuService {
    private final SajuRepository sajuRepository;

    public SajuResultResponseDTO getResult(String saju) {
        Saju s = sajuRepository.findByFiveHang(saju);
        return SajuResultResponseDTO.of(s);
    }
}
