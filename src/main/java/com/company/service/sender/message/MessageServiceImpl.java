package com.company.service.sender.message;

import com.company.service.AbstractService;
import com.company.variable.constants.UserMenu;
import com.company.variable.message.GeneralSender;
import com.company.variable.message.SenderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.company.variable.constants.FoodMenu.*;
import static com.company.variable.constants.UserLang.LANG_RU;
import static com.company.variable.constants.UserLang.LANG_UZ;
import static com.company.variable.constants.UserMenu.*;
import static com.company.variable.constants.UserStep.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:26 PM
 */

@Service
@Slf4j
public class MessageServiceImpl extends AbstractService implements MessageService {


    @Override
    public GeneralSender start(Long chatId, Message message) {
        String step = userService.getStep(chatId);
        if (valid.isFormative(UserMenu.class, message.getText())) {
            switch (message.getText()) {
                case MENU_MAIN_UZ, MENU_MAIN_RU -> {
                    return menuMain(chatId);
                }
                case MENU_LEAVE_FEEDBACK_UZ, MENU_LEAVE_FEEDBACK_RU -> {
                    return menuFeedback(chatId);
                }
                case MENU_MY_ORDERS_UZ, MENU_MY_ORDERS_RU -> {
                    return menuOrder(chatId);
                }
                case MENU_SETTINGS_UZ, MENU_SETTINGS_RU -> {
                    return menuSettings(chatId, null);
                }
                case MENU_CHANGE_LANG_UZ, MENU_CHANGE_LANG_RU -> {
                    return menuChangeLang(chatId);
                }
                case MENU_LANG_UZ, MENU_LANG_RU -> {
                    return menuLang(chatId, message.getText());
                }
                case MENU_BACK_UZ, MENU_BACK_RU -> {
                    return menuBack(chatId);
                }
                case MENU_YES_UZ, MENU_YES_RU -> {
                    return menuYes(chatId);
                }
            }

        } else {
            if (message.getText().equals("/start")) {
                return stepStart(chatId);
            }
            switch (step) {

            }
        }

        return null;
    }

    private GeneralSender menuYes(Long chatId) {
        var lang = userService.getLang(chatId).equals(LANG_UZ);

        var set = lang ? FOOD_SET_UZ : FOOD_SET_RU;
        var lavash = lang ? FOOD_LAVASH_UZ : FOOD_LAVASH_RU;
        var shourma = lang ? FOOD_SHAURMA_UZ : FOOD_SHAURMA_RU;
        var donar = lang ? FOOD_DONAR_UZ : FOOD_DONAR_RU;
        var burger = lang ? FOOD_BURGER_UZ : FOOD_BURGER_RU;
        var xotDog = lang ? FOOD_HOT_DOG_UZ : FOOD_HOT_DOG_RU;
        var desert = lang ? FOOD_DESERTS_UZ : FOOD_DESERTS_RU;
        var drink = lang ? FOOD_DRINKS_UZ : FOOD_DRINKS_RU;
        var garnir = lang ? FOOD_GARNIR_UZ : FOOD_GARNIR_RU;
        var trash = lang ? FOOD_TRASH_UZ : FOOD_TRASH_RU;
        var back = lang ? FOOD_BACK_UZ : FOOD_BACK_RU;

        var r1 = reply.getRowsWithText(set, lavash);
        var r2 = reply.getRowsWithText(shourma, donar);
        var r3 = reply.getRowsWithText(burger, xotDog);
        var r4 = reply.getRowsWithText(desert, drink);
        var r5 = reply.getRowsWithText(garnir);
        var r6 = reply.getRowsWithText(trash, back);

        var keyboard = reply.getKeyboard(r1, r2, r3, r4, r5, r6);

        var msg = "Выберите категорию.";

        return SenderMessage
                .builder()
                .chatId(chatId)
                .parseMode(ParseMode.HTML)
                .text(msg)
                .reply(keyboard)
                .build();
    }

    private GeneralSender menuBack(Long chatId) {
        var step = userService.getStep(chatId);
        if (step.equals(STEP_START)) return null;
        switch (step) {
            case STEP_FEEDBACK, STEP_SETTINGS, STEP_MAIN_MENU -> {
                return stepStart(chatId);
            }
            case STEP_CHANGE_LANG -> {
                userService.setStep(chatId, STEP_START);
                return menuSettings(chatId, null);
            }

        }
        return null;
    }

    private GeneralSender menuOrder(Long chatId) {
        var step = userService.getStep(chatId);
        if (!step.equals(STEP_START)) return null;

        var lang = userService.getLang(chatId).equals(LANG_UZ);
//        userService.setStep(chatId, STEP_ORDER);
        var msg = lang ? "Siz hech narsa buyurtma bermagansiz" : "Вы совсем ничего не заказали.";
        return SenderMessage
                .builder()
                .chatId(chatId)
                .text(msg)
                .build();
    }

    private GeneralSender menuLang(Long chatId, String text) {
        var step = userService.getStep(chatId);
        if (!step.equals(STEP_CHANGE_LANG)) return null;
        var l = text.equals(MENU_LANG_UZ) ? LANG_UZ : LANG_RU;
        userService.setLang(chatId, l);
        userService.setStep(chatId, STEP_START);
        var lang = userService.getLang(chatId).equals(LANG_UZ);
        var msg = lang ? "✅ Tayyor" : "✅ Готово";
        return menuSettings(chatId, msg);
    }

    private GeneralSender menuChangeLang(Long chatId) {
        var step = userService.getStep(chatId);

        if (!step.equals(STEP_SETTINGS)) return null;

        userService.setStep(chatId, STEP_CHANGE_LANG);

        var lang = userService.getLang(chatId).equals(LANG_UZ);

        var msg = lang ? "<b>Tilni tanlang:</b>" : "<b>Выберите язык:</b>";

        var back = lang ? MENU_BACK_UZ : MENU_BACK_RU;

        var r1 = reply.getRowsWithText(MENU_LANG_UZ, MENU_LANG_RU);
        var r2 = reply.getRowsWithText(back);

        var keyboard = reply.getKeyboard(r1, r2);

        return SenderMessage
                .builder()
                .chatId(chatId)
                .parseMode(ParseMode.HTML)
                .text(msg)
                .reply(keyboard)
                .build();
    }

    private GeneralSender menuSettings(Long chatId, String m) {
        var step = userService.getStep(chatId);

        if (!step.equals(STEP_START)) return null;

        userService.setStep(chatId, STEP_SETTINGS);

        var lang = userService.getLang(chatId).equals(LANG_UZ);

        var msg = m == null ? lang ? "<b>Harakat tanlang:</b>" : "<b>Выберите действие:</b>" : m;

        var l = lang ? MENU_CHANGE_LANG_UZ : MENU_CHANGE_LANG_RU;
        var back = lang ? MENU_BACK_UZ : MENU_BACK_RU;

        var r1 = reply.getRowsWithText(l);
        var r2 = reply.getRowsWithText(back);

        var keyboard = reply.getKeyboard(r1, r2);

        return SenderMessage
                .builder()
                .chatId(chatId)
                .parseMode(ParseMode.HTML)
                .text(msg)
                .reply(keyboard)
                .build();
    }

    private GeneralSender menuFeedback(Long chatId) {
        String step = userService.getStep(chatId);
        if (!step.equals(STEP_START)) return null;

        userService.setStep(chatId, STEP_FEEDBACK);

        var lang = userService.getLang(chatId).equals(LANG_UZ);
        String msg = lang ? "Fikringizni yuboring" : "Отправьте ваши отзывы";
        var r = reply.getRowsWithText(lang ? MENU_BACK_UZ : MENU_BACK_RU);
        var keyboard = reply.getKeyboard(r);

        return SenderMessage
                .builder()
                .chatId(chatId)
                .reply(keyboard)
                .text(msg)
                .parseMode(ParseMode.MARKDOWN)
                .build();
    }

    private GeneralSender menuMain(Long chatId) {

        var step = userService.getStep(chatId);
        if (!step.equals(STEP_START)) return null;
        var lang = userService.getLang(chatId).equals(LANG_UZ);
        userService.setStep(chatId, STEP_MAIN_MENU);

        String msg = lang
                ? "\uD83D\uDCCD Geolokatsiyani yuboring yoki yetkazib berish manzilini tanlang"
                : "Отправьте \uD83D\uDCCD геолокацию или выберите адрес доставки";


        String address = lang ? MENU_MY_ADDRESS_UZ : MENU_MY_ADDRESS_RU;
        String geo = lang ? MENU_SEND_LOCATION_UZ : MENU_SEND_LOCATION_RU;
        String back = lang ? MENU_BACK_UZ : MENU_BACK_RU;


        var r1 = reply.getRowsWithText(address);
        var r2 = reply.getRowsWithButton(
                reply.getButton(geo, true, false),
                reply.getButton(back, false, false));

        var keyboard = reply.getKeyboard(r1, r2);

        return SenderMessage
                .builder()
                .chatId(chatId)
                .parseMode(ParseMode.MARKDOWN)
                .text(msg)
                .reply(keyboard)
                .build();
    }

    private GeneralSender stepStart(Long chatId) {
        var lang = userService.getLang(chatId).equals(LANG_UZ);
        userService.setStep(chatId, STEP_START);
        String msg = lang
                ? "Quyidagilardan birini tanlang"
                : "Выберите одно из следующих";
        String menu = lang ? MENU_MAIN_UZ : MENU_MAIN_RU;
        String order = lang ? MENU_MY_ORDERS_UZ : MENU_MY_ORDERS_RU;
        String feedback = lang ? MENU_LEAVE_FEEDBACK_UZ : MENU_LEAVE_FEEDBACK_RU;
        String settings = lang ? MENU_SETTINGS_UZ : MENU_SETTINGS_RU;
        var r1 = reply.getRowsWithText(menu);
        var r2 = reply.getRowsWithText(order);
        var r3 = reply.getRowsWithText(feedback, settings);
        var keyboard = reply.getKeyboard(r1, r2, r3);

        return SenderMessage
                .builder()
                .chatId(chatId)
                .text(msg)
                .reply(keyboard)
                .parseMode(ParseMode.MARKDOWN)
                .build();
    }
}




