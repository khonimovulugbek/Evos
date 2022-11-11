package com.company.service.executor;

import com.company.variable.message.GeneralSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:59 AM
 */

@Service
@Slf4j
public class ExecutorServicesImpl implements ExecutorServices {


    @Override
    public SendMessage send(GeneralSender sender) {
        var send = SendMessage
                .builder()
                .chatId(sender.getChatId())
                .text(sender.getText())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .build();
        if (sender.getReply() != null) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    @Override
    public EditMessageText edit(GeneralSender sender) {
        var send = EditMessageText
                .builder()
                .chatId(sender.getChatId())
                .text(sender.getText())
                .messageId(sender.getMessageId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .build();
        if (isExistKeyboard(sender)) {
            InlineKeyboardMarkup reply = (InlineKeyboardMarkup) sender.getReply();
            send.setReplyMarkup(reply);
        }
        return send;
    }

    @Override
    public SendPhoto sendPhoto(GeneralSender sender) {
        var send = SendPhoto
                .builder()
                .chatId(sender.getChatId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .photo(sender.getInputFile())
                .caption(sender.getCaption())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    @Override
    public SendContact sendContact(GeneralSender sender) {
        var send = SendContact
                .builder()
                .chatId(sender.getChatId())
                .firstName(sender.getFirstName())
                .lastName(sender.getLastName())
                .phoneNumber(sender.getPhoneNumber())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    @Override
    public SendLocation sendLocation(GeneralSender sender) {
        var send = SendLocation.builder()
                .chatId(sender.getChatId())
                .latitude(sender.getLatitude())
                .longitude(sender.getLongitude())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    @Override
    public SendDocument sendDocument(GeneralSender sender) {
        var send = SendDocument
                .builder()
                .chatId(sender.getChatId())
                .parseMode(sender.getParseMode() == null ? ParseMode.MARKDOWN : sender.getParseMode())
                .document(sender.getInputFile())
                .caption(sender.getCaption())
                .build();
        if (isExistKeyboard(sender)) send.setReplyMarkup(sender.getReply());
        if (isExistReplyMessage(sender)) send.setReplyToMessageId(sender.getReplyMessageId());
        return send;
    }

    private boolean isExistReplyMessage(GeneralSender sender) {
        return sender.getMessageId() != null;
    }
    private boolean isExistKeyboard(GeneralSender sender) {
        return sender.getReply() != null;
    }
}




