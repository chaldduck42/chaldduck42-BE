package chaldduck.backend;

import chaldduck.backend.src.domain.MbtiAnswer;
import chaldduck.backend.src.domain.MbtiQuestion;
import chaldduck.backend.src.domain.Users;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@PostConstruct
	public void init() {
		MbtiQuestion mbtiQuestion1 = MbtiQuestion.builder()
				.id(1)
				.kind("EI")
				.question("오랜만의 휴일! 뭘 하면서 휴식을 취할까?")
				.build();
		MbtiAnswer mbtiAnswer1 = MbtiAnswer.builder()
				.id(1)
				.mbtiQuestion(mbtiQuestion1)
				.answer("혼자 못봤던 영화도 보고 집 청소도 하고 책도 읽어야지~") //i
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer2 = MbtiAnswer.builder()
				.id(2)
				.mbtiQuestion(mbtiQuestion1)
				.answer("당장 친구들 불러! 스트레스 풀자!~") //e
				.score(1)
				.build();
		////////////////////////////////////////
		MbtiQuestion mbtiQuestion2 = MbtiQuestion.builder()
				.id(2)
				.kind("EI")
				.question("처음보는 친구들을 만나러 간 자리")
				.build();
		MbtiAnswer mbtiAnswer3 = MbtiAnswer.builder()
				.id(3)
				.mbtiQuestion(mbtiQuestion2)
				.answer("조용히 앉아서 친구들이 오기를 기다린다") //i
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer4 = MbtiAnswer.builder()
				.id(4)
				.mbtiQuestion(mbtiQuestion2)
				.answer("내가 먼저 친해지자며 말건다") //e
				.score(1)
				.build();
		////////////////////////////////////////
		MbtiQuestion mbtiQuestion3 = MbtiQuestion.builder()
				.id(3)
				.kind("EI")
				.question("친구들과 놀 때 나는")
				.build();
		MbtiAnswer mbtiAnswer5 = MbtiAnswer.builder()
				.id(5)
				.mbtiQuestion(mbtiQuestion2)
				.answer("소수의 친구들과 진지한 대화") //i
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer6 = MbtiAnswer.builder()
				.id(6)
				.mbtiQuestion(mbtiQuestion2)
				.answer("내가 먼저 친해지자며 말건다") //e
				.score(1)
				.build();
		////////////////////////////////////////
		MbtiQuestion mbtiQuestion4 = MbtiQuestion.builder()
				.id(4)
				.kind("SN")
				.question("일할 때 나는")
				.build();
		MbtiAnswer mbtiAnswer7 = MbtiAnswer.builder()
				.id(7)
				.mbtiQuestion(mbtiQuestion2)
				.answer("남들이 하는대로 따라가는 것이 좋다") //s
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer8 = MbtiAnswer.builder()
				.id(8)
				.mbtiQuestion(mbtiQuestion2)
				.answer("스스로 나만의 방법을 만들어 나가는게 좋다") //n
				.score(1)
				.build();
		////////////////////////////////////////
		MbtiQuestion mbtiQuestion5 = MbtiQuestion.builder()
				.id(5)
				.kind("SN")
				.question("학창시절 어느 푸르른 여름날, 창밖을 보며 나는")
				.build();
		MbtiAnswer mbtiAnswer9 = MbtiAnswer.builder()
				.id(9)
				.mbtiQuestion(mbtiQuestion2)
				.answer("\"덥겠다..\" 현실적인 생각을 해본다 ") //s
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer10 = MbtiAnswer.builder()
				.id(10)
				.mbtiQuestion(mbtiQuestion2)
				.answer("\"떨어지면 어떡하지? 나무에 떨어지면 살 수 있을까?\"라며 상상의 나래를 펼친다 ") //n
				.score(1)
				.build();
		////////////////////////////////////////
		MbtiQuestion mbtiQuestion6 = MbtiQuestion.builder()
				.id(6)
				.kind("SN")
				.question("주변 사람들이 나에게 더 많이 하는 말은")
				.build();
		MbtiAnswer mbtiAnswer11 = MbtiAnswer.builder()
				.id(11)
				.mbtiQuestion(mbtiQuestion2)
				.answer("꾸준하고 참을성이 있다") //s
				.score(-1)
				.build();
		MbtiAnswer mbtiAnswer12 = MbtiAnswer.builder()
				.id(12)
				.mbtiQuestion(mbtiQuestion2)
				.answer("창의적이고 독창적이다") //n
				.score(1)
				.build();
		////////////////////////////////////////
	}

}
