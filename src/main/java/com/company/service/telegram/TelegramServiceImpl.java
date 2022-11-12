package com.company.service.telegram;

import com.company.service.sender.callback.CallBackQueryService;
import com.company.service.sender.document.DocumentService;
import com.company.service.sender.food.FoodService;
import com.company.service.sender.message.MessageService;
import com.company.service.user.UserService;
import com.company.service.valid.ValidClassService;
import com.company.variable.constants.FoodMenu;
import com.company.variable.enums.UpdateEnum;
import com.company.variable.message.GeneralSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.company.variable.enums.UpdateEnum.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:59 AM
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TelegramServiceImpl implements TelegramService {
    private final MessageService messageService;
    private final CallBackQueryService callBackQueryService;
    private final DocumentService documentService;
    private final UserService userService;
    private final FoodService foodService;

    private final ValidClassService valid;


    @Override
    public GeneralSender onUpdate(Update update) {
        UpdateEnum updateEnum = getUpdate(update);


        switch (updateEnum) {
            case MESSAGE_TEXT -> {
                return messageText(update.getMessage());
            }
            case DOCUMENT_MESSAGE -> {
                return messageDocument(update.getMessage());
            }
            case CALL_BACK_QUERY -> {
                return callBack(update.getCallbackQuery());
            }
            case LOCATION_MESSAGE -> {
                return location(update.getMessage());
            }
            case DEFAULT_UPDATE -> {
                return null;
            }
        }

        return null;
    }

    private GeneralSender location(Message message) {
        return documentService.location(message);
    }

    private GeneralSender messageDocument(Message message) {
        Long chatId = message.getChatId();
        Integer messageId = message.getMessageId();
        userService.setMessageId(chatId, messageId);
        return documentService.start(chatId, message);
    }

    private GeneralSender callBack(CallbackQuery callbackQuery) {
        Long chatId = callbackQuery.getMessage().getChatId();
        Integer messageId = callbackQuery.getMessage().getMessageId();
        userService.setMessageId(chatId, messageId);

        return callBackQueryService.start(chatId, callbackQuery);
    }

    private GeneralSender messageText(Message message) {
        var check = valid.isFormative(FoodMenu.class, message.getText());
        if (check){
           return foodService.start(message);
        }
        Long chatId = message.getChatId();
        Integer messageId = message.getMessageId();
        userService.setMessageId(chatId, messageId);
        return messageService.start(chatId, message);
    }

    private UpdateEnum getUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) return MESSAGE_TEXT;
            if (message.hasVoice()) return VOICE_MESSAGE;
            if (message.hasPhoto()) return PHOTO_MESSAGE;
            if (message.hasDocument()) return DOCUMENT_MESSAGE;
            if (message.hasContact()) return CONTACT_MESSAGE;
            if (message.hasAnimation()) return ANIMATION_MESSAGE;
            if (message.hasAudio()) return AUDIO_MESSAGE;
            if (message.hasLocation()) return LOCATION_MESSAGE;
        }

        if (update.hasCallbackQuery()) return CALL_BACK_QUERY;
        return DEFAULT_UPDATE;
    }
}




