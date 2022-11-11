package com.company.service.keyboard.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:18 PM
 */

public interface InlineKeyboardService {
    InlineKeyboardButton getButton(String text, String callBackData);

    List<InlineKeyboardButton> getButtonList(InlineKeyboardButton... buttons);

    InlineKeyboardMarkup getKeyboard(List<List<InlineKeyboardButton>> lists);

    default List<List<InlineKeyboardButton>> getInlineList() {
        return new ArrayList<>();
    }
}
