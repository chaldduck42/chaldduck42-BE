package chaldduck.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Chaldduck42 API Docs", description = "Chalddck42 백엔드 API 문서입니다.", version = "v1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        // 추후 토큰, server 분리하여 사용할 떼 관련 설정
        return new OpenAPI();
    }
}
