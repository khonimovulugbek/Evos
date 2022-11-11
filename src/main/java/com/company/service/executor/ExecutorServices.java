package com.company.service.executor;

import com.company.variable.message.GeneralSender;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 11:59 AM
 */

public interface ExecutorServices {
    SendMessage send(GeneralSender start);

    EditMessageText edit(GeneralSender start);

    SendPhoto sendPhoto(GeneralSender start);

    SendContact sendContact(GeneralSender sender);

    SendLocation sendLocation(GeneralSender sender);

    SendDocument sendDocument(GeneralSender sender);
}
