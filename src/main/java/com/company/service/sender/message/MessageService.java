package com.company.service.sender.message;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:25 PM
 */

public interface MessageService {
    GeneralSender start(Long chatId, Message message);
}
