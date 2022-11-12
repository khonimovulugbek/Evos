package com.company;

import com.company.config.BotConfig;
import com.company.service.executor.ExecutorServices;
import com.company.service.telegram.TelegramService;
import com.company.variable.message.GeneralSender;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.telegram.telegrambots.meta.api.methods.ActionType.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:56 AM
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class Telegram extends TelegramLongPollingBot {
    private final BotConfig config;
    private final ExecutorServices executorServices;
    private final TelegramService telegramService;

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
//        var p = update.getMessage().getPhoto();
//        GetFile file = new GetFile();
//        file.setFileId(p.get(2).getFileId());
//        var url = execute(file).getFileUrl(getBotToken());
//        System.out.println(url);
        var sender = telegramService.onUpdate(update);
        if (sender != null) {
            executeMessage(sender);
        }
    }

    private void executeMessage(GeneralSender sender) {
        try {
            switch (sender.getType()) {
                case SEND_MESSAGE -> {
                    execute(sendAction(sender.getChatId(), TYPING));
                    execute(executorServices.send(sender));
                }
                case EDIT_MESSAGE -> {
                    execute(sendAction(sender.getChatId(), TYPING));
                    execute(executorServices.edit(sender));
                }
                case SEND_PHOTO -> {
                    execute(sendAction(sender.getChatId(), UPLOADPHOTO));
                    execute(executorServices.sendPhoto(sender));
                }
                case SEND_LOCATION -> {
                    execute(sendAction(sender.getChatId(), FINDLOCATION));
                    execute(executorServices.sendLocation(sender));
                }
                case SEND_CONTACT -> {
                    execute(sendAction(sender.getChatId(), TYPING));
                    execute(executorServices.sendContact(sender));
                }
                case SEND_DOCUMENT -> {
                    execute(sendAction(sender.getChatId(), UPLOADDOCUMENT));
                    execute(executorServices.sendDocument(sender));
                }
            }
        } catch (TelegramApiException e) {
            log.warn("Bot is not working " + e);
        }
    }

    private SendChatAction sendAction(Long chatId, ActionType type) {
        SendChatAction sendChatAction = new SendChatAction();
        sendChatAction.setAction(type);
        sendChatAction.setChatId(chatId);
        return sendChatAction;
    }
}




