package com.company.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:48 AM
 */

@Configuration
@Data
@PropertySource("/application.properties")
public class BotConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String token;
}




