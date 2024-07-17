package chaldduck.backend;

import chaldduck.backend.src.domain.*;
import chaldduck.backend.src.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication {

	private final MbtiAnswerRepository mbtiAnswerRepository;
	private final MbtiQuestionRepository mbtiQuestionRepository;
	private final MbtiCompatibilityDataRepository mbtiCompatibilityDataRepository;
	private final SajuCompatabilityDataRepository sajuCompatabilityDataRepository;
	private final SajuRepository sajuRepository;
	private final UsersRepository usersRepository;
	private final FriendCompatabilityDataRepository friendCompatabilityDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/**
	 * TODO test 데이터이므로 추후 DB 구축 후 삭제 필요
	 * 데이터 초기 세팅 필요할 때만 주석 풀어서 사용하고 이후에는 ddl-auto update로 변경해서 사용 X !!
	 */
//	@PostConstruct
//	public void init() throws ParseException {
//		MbtiQuestion mbtiQuestion1 = MbtiQuestion.builder()
//				.id(1)
//				.kind("EI")
//				.question("오랜만의 휴일! 뭘 하면서 휴식을 취할까?")
//				.build();
//		MbtiAnswer mbtiAnswer1 = MbtiAnswer.builder()
//				.id(1)
//				.mbtiQuestion(mbtiQuestion1)
//				.answer("혼자 못봤던 영화도 보고 집 청소도 하고 책도 읽어야지~") //i
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer2 = MbtiAnswer.builder()
//				.id(2)
//				.mbtiQuestion(mbtiQuestion1)
//				.answer("당장 친구들 불러! 스트레스 풀자!~") //e
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion1);
//		mbtiAnswerRepository.save(mbtiAnswer1);
//		mbtiAnswerRepository.save(mbtiAnswer2);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion2 = MbtiQuestion.builder()
//				.id(2)
//				.kind("EI")
//				.question("처음보는 친구들을 만나러 간 자리")
//				.build();
//		MbtiAnswer mbtiAnswer3 = MbtiAnswer.builder()
//				.id(3)
//				.mbtiQuestion(mbtiQuestion2)
//				.answer("조용히 앉아서 친구들이 오기를 기다린다") //i
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer4 = MbtiAnswer.builder()
//				.id(4)
//				.mbtiQuestion(mbtiQuestion2)
//				.answer("내가 먼저 친해지자며 말건다") //e
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion2);
//		mbtiAnswerRepository.save(mbtiAnswer3);
//		mbtiAnswerRepository.save(mbtiAnswer4);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion3 = MbtiQuestion.builder()
//				.id(3)
//				.kind("EI")
//				.question("친구들과 놀 때 나는")
//				.build();
//		MbtiAnswer mbtiAnswer5 = MbtiAnswer.builder()
//				.id(5)
//				.mbtiQuestion(mbtiQuestion3)
//				.answer("소수의 친구들과 진지한 대화") //i
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer6 = MbtiAnswer.builder()
//				.id(6)
//				.mbtiQuestion(mbtiQuestion3)
//				.answer("내가 먼저 친해지자며 말건다") //e
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion3);
//		mbtiAnswerRepository.save(mbtiAnswer5);
//		mbtiAnswerRepository.save(mbtiAnswer6);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion4 = MbtiQuestion.builder()
//				.id(4)
//				.kind("SN")
//				.question("일할 때 나는")
//				.build();
//		MbtiAnswer mbtiAnswer7 = MbtiAnswer.builder()
//				.id(7)
//				.mbtiQuestion(mbtiQuestion4)
//				.answer("남들이 하는대로 따라가는 것이 좋다") //s
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer8 = MbtiAnswer.builder()
//				.id(8)
//				.mbtiQuestion(mbtiQuestion4)
//				.answer("스스로 나만의 방법을 만들어 나가는게 좋다") //n
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion4);
//		mbtiAnswerRepository.save(mbtiAnswer7);
//		mbtiAnswerRepository.save(mbtiAnswer8);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion5 = MbtiQuestion.builder()
//				.id(5)
//				.kind("SN")
//				.question("학창시절 어느 푸르른 여름날, 창밖을 보며 나는")
//				.build();
//		MbtiAnswer mbtiAnswer9 = MbtiAnswer.builder()
//				.id(9)
//				.mbtiQuestion(mbtiQuestion5)
//				.answer("\"덥겠다..\" 현실적인 생각을 해본다 ") //s
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer10 = MbtiAnswer.builder()
//				.id(10)
//				.mbtiQuestion(mbtiQuestion5)
//				.answer("\"떨어지면 어떡하지? 나무에 떨어지면 살 수 있을까?\"라며 상상의 나래를 펼친다 ") //n
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion5);
//		mbtiAnswerRepository.save(mbtiAnswer9);
//		mbtiAnswerRepository.save(mbtiAnswer10);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion6 = MbtiQuestion.builder()
//				.id(6)
//				.kind("SN")
//				.question("주변 사람들이 나에게 더 많이 하는 말은")
//				.build();
//		MbtiAnswer mbtiAnswer11 = MbtiAnswer.builder()
//				.id(11)
//				.mbtiQuestion(mbtiQuestion6)
//				.answer("꾸준하고 참을성이 있다") //s
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer12 = MbtiAnswer.builder()
//				.id(12)
//				.mbtiQuestion(mbtiQuestion6)
//				.answer("창의적이고 독창적이다") //n
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion6);
//		mbtiAnswerRepository.save(mbtiAnswer11);
//		mbtiAnswerRepository.save(mbtiAnswer12);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion7 = MbtiQuestion.builder()
//				.id(7)
//				.kind("TF")
//				.question("회사에서 내가 더 듣고싶은 말은?")
//				.build();
//		MbtiAnswer mbtiAnswer13 = MbtiAnswer.builder()
//				.id(13)
//				.mbtiQuestion(mbtiQuestion7)
//				.answer("\"성격은 별론데 일 하나는 똑부러지게 잘해~\"") //t
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer14 = MbtiAnswer.builder()
//				.id(14)
//				.mbtiQuestion(mbtiQuestion7)
//				.answer("\"일은 좀 못해도 사람은 참 좋아~\"") //f
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion7);
//		mbtiAnswerRepository.save(mbtiAnswer13);
//		mbtiAnswerRepository.save(mbtiAnswer14);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion8 = MbtiQuestion.builder()
//				.id(8)
//				.kind("TF")
//				.question("친구랑 아주 슬픈 영화를 보러 갔다. 영화가 끝나고 나는")
//				.build();
//		MbtiAnswer mbtiAnswer15 = MbtiAnswer.builder()
//				.id(15)
//				.mbtiQuestion(mbtiQuestion8)
//				.answer("나라면 저렇게 안했을텐데.. 왜 울지?") //t
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer16 = MbtiAnswer.builder()
//				.id(16)
//				.mbtiQuestion(mbtiQuestion8)
//				.answer("영화가 너무 슬펐어..") //f
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion8);
//		mbtiAnswerRepository.save(mbtiAnswer15);
//		mbtiAnswerRepository.save(mbtiAnswer16);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion9 = MbtiQuestion.builder()
//				.id(9)
//				.kind("TF")
//				.question("\"나 일 못한다고 상사한테 까였어ㅠㅠ\"라고 말하는 친구에게 나는")
//				.build();
//		MbtiAnswer mbtiAnswer17 = MbtiAnswer.builder()
//				.id(17)
//				.mbtiQuestion(mbtiQuestion9)
//				.answer("너가 뭘 잘못했는데? 큰 실수했어?") //t
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer18 = MbtiAnswer.builder()
//				.id(18)
//				.mbtiQuestion(mbtiQuestion9)
//				.answer("헐 괜찮아? 그 상사 너무하네~") //f
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion9);
//		mbtiAnswerRepository.save(mbtiAnswer17);
//		mbtiAnswerRepository.save(mbtiAnswer18);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion10 = MbtiQuestion.builder()
//				.id(10)
//				.kind("JP")
//				.question("오늘은 친구와의 약속이 있는 날! 약속 한시간 전 나는")
//				.build();
//		MbtiAnswer mbtiAnswer19 = MbtiAnswer.builder()
//				.id(19)
//				.mbtiQuestion(mbtiQuestion10)
//				.answer("우리 어디서 몇시에 볼래?") //p
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer20 = MbtiAnswer.builder()
//				.id(20)
//				.mbtiQuestion(mbtiQuestion10)
//				.answer("그때 예약해둔 맛집 앞에서 12까지 봐~") //j
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion10);
//		mbtiAnswerRepository.save(mbtiAnswer19);
//		mbtiAnswerRepository.save(mbtiAnswer20);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion11 = MbtiQuestion.builder()
//				.id(11)
//				.kind("JP")
//				.question("친구가 우리집에 놀러와서 가위를 찾는다!")
//				.build();
//		MbtiAnswer mbtiAnswer21 = MbtiAnswer.builder()
//				.id(21)
//				.mbtiQuestion(mbtiQuestion11)
//				.answer("음 어디다 뒀지? 책상 한번 봐볼래?") //p
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer22 = MbtiAnswer.builder()
//				.id(22)
//				.mbtiQuestion(mbtiQuestion11)
//				.answer("그거 왼쪽 서랍 세번째 칸에 있어") //j
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion11);
//		mbtiAnswerRepository.save(mbtiAnswer21);
//		mbtiAnswerRepository.save(mbtiAnswer22);
//		////////////////////////////////////////
//		MbtiQuestion mbtiQuestion12 = MbtiQuestion.builder()
//				.id(12)
//				.kind("JP")
//				.question("과제 제출 마감 30분 전! 나는")
//				.build();
//		MbtiAnswer mbtiAnswer23 = MbtiAnswer.builder()
//				.id(23)
//				.mbtiQuestion(mbtiQuestion12)
//				.answer("막판 스퍼트! 1분 1초도 놓칠 수 없어!") //p
//				.score(-1)
//				.build();
//		MbtiAnswer mbtiAnswer24 = MbtiAnswer.builder()
//				.id(24)
//				.mbtiQuestion(mbtiQuestion12)
//				.answer("이거 끝났어! 내가 미리 다 해놨지~") //j
//				.score(1)
//				.build();
//		mbtiQuestionRepository.save(mbtiQuestion12);
//		mbtiAnswerRepository.save(mbtiAnswer23);
//		mbtiAnswerRepository.save(mbtiAnswer24);
//
//		////////////////////////////////////////
//		MbtiCompatibilityData mbtiCompatibilityData1 = MbtiCompatibilityData.builder()
//				.id(1)
//				.mbti1("ISTJ")
//				.mbti2("ISTJ")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData2 = MbtiCompatibilityData.builder()
//				.id(2)
//				.mbti1("ISTJ")
//				.mbti2("ISFJ")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData3 = MbtiCompatibilityData.builder()
//				.id(3)
//				.mbti1("ISTJ")
//				.mbti2("INFJ")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData4 = MbtiCompatibilityData.builder()
//				.id(4)
//				.mbti1("ISTJ")
//				.mbti2("INTJ")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData5 = MbtiCompatibilityData.builder()
//				.id(5)
//				.mbti1("ISTJ")
//				.mbti2("ISTP")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData6 = MbtiCompatibilityData.builder()
//				.id(6)
//				.mbti1("ISTJ")
//				.mbti2("ISFP")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData7 = MbtiCompatibilityData.builder()
//				.id(7)
//				.mbti1("ISTJ")
//				.mbti2("INFP")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData8 = MbtiCompatibilityData.builder()
//				.id(8)
//				.mbti1("ISTJ")
//				.mbti2("INTP")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData9 = MbtiCompatibilityData.builder()
//				.id(9)
//				.mbti1("ISTJ")
//				.mbti2("ESTP")
//				.image("image")
//				.description("description")
//				.build();
//		MbtiCompatibilityData mbtiCompatibilityData10 = MbtiCompatibilityData.builder()
//				.id(10)
//				.mbti1("ISTJ")
//				.mbti2("ESFP")
//				.image("image")
//				.description("description")
//				.build();
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData1);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData2);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData3);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData4);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData5);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData6);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData7);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData8);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData9);
//		mbtiCompatibilityDataRepository.save(mbtiCompatibilityData10);
//
//		////////////////////////////////////////
//		Saju saju1 = Saju.builder()
//				.id(1)
//				.fiveHang("갑자")
//				.image("saju1 image")
//				.description("saju1 description")
//				.build();
//		Saju saju2 = Saju.builder()
//				.id(2)
//				.fiveHang("을축")
//				.image("saju2 image")
//				.description("saju2 description")
//				.build();
//		Saju saju3 = Saju.builder()
//				.id(3)
//				.fiveHang("병인")
//				.image("saju3 image")
//				.description("saju3 description")
//				.build();
//		Saju saju4 = Saju.builder()
//				.id(4)
//				.fiveHang("정묘")
//				.image("saju4 image")
//				.description("saju4 description")
//				.build();
//		Saju saju5 = Saju.builder()
//				.id(5)
//				.fiveHang("무기")
//				.image("saju5 image")
//				.description("saju5 description")
//				.build();
//		Saju saju6 = Saju.builder()
//				.id(6)
//				.fiveHang("기진")
//				.image("saju6 image")
//				.description("saju6 description")
//				.build();
//		sajuRepository.save(saju1);
//		sajuRepository.save(saju2);
//		sajuRepository.save(saju3);
//		sajuRepository.save(saju4);
//		sajuRepository.save(saju5);
//		sajuRepository.save(saju6);
//
//		////////////////////////////////////////
//		SajuCompatibilityData sajuCompatibilityData1 = SajuCompatibilityData.builder()
//				.id(1)
//				.saju1(saju1)
//				.saju2(saju2)
//				.image("image")
//				.description("description")
//				.build();
//		SajuCompatibilityData sajuCompatibilityData2 = SajuCompatibilityData.builder()
//				.id(2)
//				.saju1(saju1)
//				.saju2(saju3)
//				.image("image")
//				.description("description")
//				.build();
//		SajuCompatibilityData sajuCompatibilityData3 = SajuCompatibilityData.builder()
//				.id(3)
//				.saju1(saju1)
//				.saju2(saju4)
//				.image("image")
//				.description("description")
//				.build();
//		SajuCompatibilityData sajuCompatibilityData4 = SajuCompatibilityData.builder()
//				.id(4)
//				.saju1(saju1)
//				.saju2(saju5)
//				.image("image")
//				.description("description")
//				.build();
//		SajuCompatibilityData sajuCompatibilityData5 = SajuCompatibilityData.builder()
//				.id(5)
//				.saju1(saju1)
//				.saju2(saju6)
//				.image("image")
//				.description("description")
//				.build();
//		SajuCompatibilityData sajuCompatibilityData6 = SajuCompatibilityData.builder()
//				.id(6)
//				.saju1(saju2)
//				.saju2(saju3)
//				.image("image")
//				.description("description")
//				.build();
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData1);
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData2);
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData3);
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData4);
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData5);
//		sajuCompatabilityDataRepository.save(sajuCompatibilityData6);
//
//		////////////////////////////////////////
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Users users1 = Users.builder()
//				.id(1)
//				.saju(saju1)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ISTJ")
//				.nickname("예림")
//				.url("He194kx")
//				.build();
//		Users users2 = Users.builder()
//				.id(2)
//				.saju(saju2)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ESTJ")
//				.nickname("보경")
//				.url(generateRandomString())
//				.build();
//		Users users3 = Users.builder()
//				.id(3)
//				.saju(saju3)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ISTP")
//				.nickname("유림")
//				.url(generateRandomString())
//				.build();
//		Users users4 = Users.builder()
//				.id(4)
//				.saju(saju4)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ESTP")
//				.nickname("현욱")
//				.url(generateRandomString())
//				.build();
//		Users users5 = Users.builder()
//				.id(5)
//				.saju(saju5)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ISFJ")
//				.nickname("영덕")
//				.url(generateRandomString())
//				.build();
//		Users users6 = Users.builder()
//				.id(6)
//				.saju(saju6)
//				.birth(sdf.parse("1996-01-01"))
//				.mbti("ESFJ")
//				.nickname("상연")
//				.url(generateRandomString())
//				.build();
//		usersRepository.save(users1);
//		usersRepository.save(users2);
//		usersRepository.save(users3);
//		usersRepository.save(users4);
//		usersRepository.save(users5);
//		usersRepository.save(users6);
//
//		////////////////////////////////////////
//		FriendCompatibilityData friendCompatibilityData1 = FriendCompatibilityData.builder()
//				.id(1)
//				.linkOwner(users1)
//				.friend(users2)
//				.mbtiCompatibility(mbtiCompatibilityData1)
//				.sajuCompatability(sajuCompatibilityData1)
//				.build();
//		FriendCompatibilityData friendCompatibilityData2 = FriendCompatibilityData.builder()
//				.id(2)
//				.linkOwner(users1)
//				.friend(users3)
//				.mbtiCompatibility(mbtiCompatibilityData2)
//				.sajuCompatability(sajuCompatibilityData2)
//				.build();
//		FriendCompatibilityData friendCompatibilityData3 = FriendCompatibilityData.builder()
//				.id(3)
//				.linkOwner(users1)
//				.friend(users4)
//				.mbtiCompatibility(mbtiCompatibilityData3)
//				.sajuCompatability(sajuCompatibilityData3)
//				.build();
//		FriendCompatibilityData friendCompatibilityData4 = FriendCompatibilityData.builder()
//				.id(4)
//				.linkOwner(users1)
//				.friend(users5)
//				.mbtiCompatibility(mbtiCompatibilityData4)
//				.sajuCompatability(sajuCompatibilityData4)
//				.build();
//		FriendCompatibilityData friendCompatibilityData5 = FriendCompatibilityData.builder()
//				.id(5)
//				.linkOwner(users1)
//				.friend(users6)
//				.mbtiCompatibility(mbtiCompatibilityData5)
//				.sajuCompatability(sajuCompatibilityData5)
//				.build();
//		FriendCompatibilityData friendCompatibilityData6 = FriendCompatibilityData.builder()
//				.id(6)
//				.linkOwner(users2)
//				.friend(users3)
//				.mbtiCompatibility(mbtiCompatibilityData6)
//				.sajuCompatability(sajuCompatibilityData6)
//				.build();
//		friendCompatabilityDataRepository.save(friendCompatibilityData1);
//		friendCompatabilityDataRepository.save(friendCompatibilityData2);
//		friendCompatabilityDataRepository.save(friendCompatibilityData3);
//		friendCompatabilityDataRepository.save(friendCompatibilityData4);
//		friendCompatabilityDataRepository.save(friendCompatibilityData5);
//		friendCompatabilityDataRepository.save(friendCompatibilityData6);
//	}

	private String generateRandomString() {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int length = 6;
		SecureRandom random = new SecureRandom();
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			stringBuilder.append(CHARACTERS.charAt(randomIndex));
		}
		return stringBuilder.toString();
	}
}
