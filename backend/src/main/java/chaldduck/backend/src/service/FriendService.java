package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.FriendCompatibilityData;
import chaldduck.backend.src.domain.MbtiCompatibilityData;
import chaldduck.backend.src.domain.SajuCompatibilityData;
import chaldduck.backend.src.domain.Users;
import chaldduck.backend.src.dto.request.SajuCompabilityRequestDTO;
import chaldduck.backend.src.dto.response.FriendResponseDTO;
import chaldduck.backend.src.dto.response.SajuCompabilityResponseDTO;
import chaldduck.backend.src.repository.FriendCompatabilityDataRepository;
import chaldduck.backend.src.repository.SajuCompatabilityDataRepository;
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
        SajuCompatibilityData sajuCompatibilityData = sajuCompatabilityDataRepository.findBySaju1AndSaju2(sajuCompabilityRequestDTO.getFriendSaju(), sajuCompabilityRequestDTO.getMySaju());
        return SajuCompabilityResponseDTO.of(sajuCompatibilityData);

    }
}
