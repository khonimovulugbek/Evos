package com.company.variable.message;

import com.company.variable.enums.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Getter
@Setter
@Builder
public class SenderMessage implements GeneralSender {

    private Long chatId;
    private String text;
    private String parseMode;
    private ReplyKeyboard reply;
    private Integer replyMessageId;


    @Override
    public MessageType getType() {
        return MessageType.SEND_MESSAGE;
    }
}
