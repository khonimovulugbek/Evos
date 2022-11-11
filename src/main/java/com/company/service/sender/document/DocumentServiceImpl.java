package com.company.service.sender.document;

import com.company.service.AbstractService;
import com.company.variable.message.GeneralSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:24 PM
 */

@Service
@Slf4j
public class DocumentServiceImpl extends AbstractService implements DocumentService {

    @Override
    public GeneralSender start(Long chatId, Message message) {
        return null;
    }
}




