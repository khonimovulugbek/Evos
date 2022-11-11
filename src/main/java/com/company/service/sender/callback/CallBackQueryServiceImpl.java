package com.company.service.sender.callback;

import com.company.service.AbstractService;
import com.company.variable.message.GeneralSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:23 PM
 */

@Service
@Slf4j
public class CallBackQueryServiceImpl extends AbstractService implements CallBackQueryService {


    @Override
    public GeneralSender start(Long chatId, CallbackQuery callbackQuery) {
        return null;
    }
}




