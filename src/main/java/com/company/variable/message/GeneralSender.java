package com.company.variable.message;

import com.company.variable.enums.MessageType;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import java.awt.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:07 PM
 */

public interface GeneralSender {
    Long getChatId();

    default String getText() {
        return null;
    }

    default String getParseMode() {
        return ParseMode.MARKDOWN;
    }

    default ReplyKeyboard getReply() {
        return null;
    }

    default Integer getMessageId() {
        return null;
    }

    default Integer getReplyMessageId() {
        return null;
    }

    MessageType getType();

    default String getCaption() {
        return null;
    }

    default InputFile getInputFile() {
        return null;
    }

    default Double getLatitude() {
        return null;
    }

    default Double getLongitude() {
        return null;
    }

    default String getFirstName() {
        return null;
    }

    default String getLastName() {
        return null;
    }

    default String getPhoneNumber() {
        return null;
    }

}
