package com.company.service.keyboard.inline;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:18 PM
 */

@Service
public class InlineKeyboardServiceImpl implements InlineKeyboardService {

    @Override
    public InlineKeyboardButton getButton(String text, String callBackData) {
        InlineKeyboardButton keyboardButton = new InlineKeyboardButton();
        keyboardButton.setText(text);
        keyboardButton.setCallbackData(callBackData);
        return keyboardButton;
    }


    @Override
    public List<InlineKeyboardButton> getButtonList(InlineKeyboardButton... buttons) {
        return new ArrayList<>(List.of(buttons));
    }


    @Override
    public InlineKeyboardMarkup getKeyboard(List<List<InlineKeyboardButton>> lists) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(lists);
        return inlineKeyboardMarkup;
    }
}




