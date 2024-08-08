package chaldduck.backend.src.service;

import chaldduck.backend.src.domain.*;
import chaldduck.backend.src.dto.request.SajuCompabilityRequestDTO;
import chaldduck.backend.src.dto.response.FriendDetailResponseDTO;
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
import java.util.Optional;

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
            // 친구 정보(총 점수, 설명)를 가지고 있는 DTO
            FriendResponseDTO friendResponseDTO = FriendResponseDTO.of(friend, friendCompatibilityData);
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

    public FriendDetailResponseDTO getFriendDetail(String urlHash, int friendId) {
        Users linkOwner = usersRepository.findByUrl(urlHash);
        Optional<Users> friend = usersRepository.findById(friendId);
        if(friend.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 친구입니다.");
        } else {
            FriendCompatibilityData friendCompatibilityData = friendCompatabilityDataRepository.findByLinkOwnerAndFriend(linkOwner, friend.get()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 친구입니다."));
            SajuCompatibilityData sajuCompatability = friendCompatibilityData.getSajuCompatability();
            MbtiCompatibilityData mbtiCompatibility = friendCompatibilityData.getMbtiCompatibility();
            return FriendDetailResponseDTO.of(friend.get(), sajuCompatability, mbtiCompatibility);
        }
    }
}
