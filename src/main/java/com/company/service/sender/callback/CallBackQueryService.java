package com.company.service.sender.callback;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:22 PM
 */

public interface CallBackQueryService {
    GeneralSender start(Long chatId, CallbackQuery callbackQuery);
}
