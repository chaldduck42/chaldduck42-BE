package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.*;
import chaldduck.backend.src.dto.request.SajuCompabilityRequestDTO;
import chaldduck.backend.src.dto.response.FriendResponseDTO;
import chaldduck.backend.src.dto.response.SajuCompabilityResponseDTO;
import chaldduck.backend.src.repository.FriendCompatabilityDataRepository;
import chaldduck.backend.src.repository.SajuCompatabilityDataRepository;
import chaldduck.backend.src.repository.SajuRepository;
import chaldduck.backend.src.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final UsersRepository usersRepository;
    private final FriendCompatabilityDataRepository friendCompatabilityDataRepository;
    private final SajuCompatabilityDataRepository sajuCompatabilityDataRepository;
    private final SajuRepository sajuRepository;
    public List<FriendResponseDTO> getFriendList(String urlHash) {
        List<FriendResponseDTO> friendResponseDTOList = new ArrayList<>();
        Users linkOwner = usersRepository.findByUrl(urlHash);   // 링크의 주인
        List<FriendCompatibilityData> friendList = friendCompatabilityDataRepository.findALlByLinkOwner(linkOwner);
        for (FriendCompatibilityData friendCompatibilityData : friendList) {
            // 링크 주인의 각 친구
            Users friend = friendCompatibilityData.getFriend();
            // 친구 정보
            SajuCompatibilityData sajuCompatability = friendCompatibilityData.getSajuCompatability();
            MbtiCompatibilityData mbtiCompatibilityData = friendCompatibilityData.getMbtiCompatibility();
            FriendResponseDTO friendResponseDTO = FriendResponseDTO.of(friend, sajuCompatability, mbtiCompatibilityData);
            friendResponseDTOList.add(friendResponseDTO);
        }
        return friendResponseDTOList;
    }

    public SajuCompabilityResponseDTO getSajuCompability(SajuCompabilityRequestDTO sajuCompabilityRequestDTO) {
        Saju saju1 = sajuRepository.findByFiveHang(sajuCompabilityRequestDTO.getFriendSaju());
        Saju saju2 = sajuRepository.findByFiveHang(sajuCompabilityRequestDTO.getMySaju());

        SajuCompatibilityData sajuCompatibilityData = sajuCompatabilityDataRepository.findBySaju1AndSaju2(saju1, saju2);
        return SajuCompabilityResponseDTO.of(sajuCompatibilityData);

    }
}
