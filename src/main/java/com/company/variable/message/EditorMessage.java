package com.company.variable.message;

import com.company.variable.enums.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:08 PM
 */
@Getter
@Setter
@Builder
public class EditorMessage implements GeneralSender {
    private Long chatId;
    private String text;
    private String parseMode;
    private ReplyKeyboard reply;
    private Integer messageId;

    @Override
    public MessageType getType() {
        return MessageType.EDIT_MESSAGE;
    }
}




