package com.company.service.sender.food;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Author : Khonimov Ulugbek
 * Date : 12.11.2022
 * Time : 2:32 AM
 */

public interface FoodService {
    GeneralSender start(Message message);
}
