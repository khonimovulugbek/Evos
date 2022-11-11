package com.company.service.telegram;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:59 AM
 */

public interface TelegramService {
    GeneralSender onUpdate(Update update);
}
