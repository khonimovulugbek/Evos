package com.company.config;

import com.company.Telegram;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:51 AM
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class BotInitializer {
    private final Telegram bot;

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
        } catch (TelegramApiException e) {
            log.warn("Bot Initializer(){}", e.getMessage());
        }
    }
}




