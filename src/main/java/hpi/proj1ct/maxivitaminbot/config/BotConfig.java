package hpi.proj1ct.maxivitaminbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jana Metz on 20.05.23
 */
@Configuration
@EnableScheduling
@Data
@PropertySource("application.properties")
public class BotConfig {
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token;
    @Value("${bot.owner}")
    Long ownerId;
}
