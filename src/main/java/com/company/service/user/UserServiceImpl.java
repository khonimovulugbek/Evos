package com.company.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.company.variable.constants.UserLang.LANG_UZ;
import static com.company.variable.constants.UserStep.STEP_START;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:05 PM
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final Map<Long, String> mapStep = new HashMap<>();
    private final Map<Long, String> mapLang = new HashMap<>();
    private final Map<Long, Integer> mapMessageId = new HashMap<>();


    @Override
    public void setStep(Long chatId, String step) {
        mapStep.put(chatId, step);
    }

    @Override
    public void setLang(Long chatId, String lang) {
        mapLang.put(chatId, lang);
    }

    @Override
    public void setMessageId(Long chatId, Integer messageId) {
        mapMessageId.put(chatId, messageId);
    }

    @Override
    public String getStep(Long chatId) {
        mapStep.putIfAbsent(chatId, STEP_START);
        return mapStep.get(chatId);
    }

    @Override
    public String getLang(Long chatId) {
        mapLang.putIfAbsent(chatId, LANG_UZ);
        return mapLang.get(chatId);
    }

    @Override
    public Integer getMessageId(Long chatId) {
        return mapMessageId.get(chatId);
    }
}




