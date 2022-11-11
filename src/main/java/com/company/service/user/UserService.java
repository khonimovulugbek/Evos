package com.company.service.user;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:04 PM
 */

public interface UserService {
    void setStep(Long chatId, String step);

    String getStep(Long chatId);

    void setLang(Long chatId, String lang);

    String getLang(Long chatId);

    void setMessageId(Long chatId, Integer messageId);

    Integer getMessageId(Long chatId);
}
