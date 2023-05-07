package ir.ghazale.Personalwebapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("سرویس مدیریت کاربران")
                        .description("عملیات حذف،اضافه،بروزرسانی و یافتن کاربر")
                        .version("1.0"));
    }
}