package com.company.service.keyboard.reply;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:21 PM
 */

@Service
public class ReplyKeyboardServiceImpl implements ReplyKeyboardService {

    @Override
    public KeyboardRow getRowsWithButton(KeyboardButton... rows) {

        KeyboardRow row = new KeyboardRow();
        row.addAll(Arrays.asList(rows));
        return row;
    }

    @Override
    public KeyboardRow getRowsWithText(String... rows) {

        KeyboardRow row = new KeyboardRow();
        row.addAll(Arrays.asList(rows));
        return row;
    }

    @Override
    public KeyboardButton getButton(String text, boolean location, boolean contact) {

        return KeyboardButton
                .builder()
                .requestLocation(location)
                .requestContact(contact)
                .text(text)
                .build();
    }

    @Override
    public ReplyKeyboardMarkup getKeyboard(KeyboardRow... rows) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(new ArrayList<>(List.of(rows)));
        return replyKeyboardMarkup;
    }
}




