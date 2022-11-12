package com.company.service.sender.food;

import com.company.service.AbstractService;
import com.company.variable.message.GeneralSender;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * Author : Khonimov Ulugbek
 * Date : 12.11.2022
 * Time : 2:32 AM
 */
@Service
public class FoodServiceImpl extends AbstractService implements FoodService {

    @Override
    public GeneralSender start(Message message) {
        return null;
    }
}




