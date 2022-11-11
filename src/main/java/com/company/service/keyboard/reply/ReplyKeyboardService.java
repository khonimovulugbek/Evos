package com.company.service.keyboard.reply;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:20 PM
 */

public interface ReplyKeyboardService {

    KeyboardRow getRowsWithButton(KeyboardButton... rows);

    KeyboardRow getRowsWithText(String... rows);

    KeyboardButton getButton(String text, boolean location, boolean contact);

    ReplyKeyboardMarkup getKeyboard(KeyboardRow... rows);

}
