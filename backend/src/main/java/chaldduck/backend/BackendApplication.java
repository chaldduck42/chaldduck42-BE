package chaldduck.backend;

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

	}

}
