package message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "message.controller",
        "message.service"
})
@Slf4j
public class MessageApplication {
    public static void main(String[] args) {

        SpringApplication.run(MessageApplication.class, args);
    }
}
