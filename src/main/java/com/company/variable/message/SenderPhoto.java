package com.company.variable.message;

import com.company.variable.enums.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

@Getter
@Setter
@Builder
public class SenderPhoto implements GeneralSender {
    private Long chatId;
    private String parseMode;
    private ReplyKeyboard reply;
    private Integer replyMessageId;
    private String caption;
    private InputFile inputFile;

    @Override
    public MessageType getType() {
        return MessageType.SEND_PHOTO;
    }
}
