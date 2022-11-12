package com.company.service.sender.document;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.objects.Message;


/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:24 PM
 */

public interface DocumentService {
    GeneralSender start(Long chatId, Message message);

    GeneralSender location(Message message);
}
