package com.company.service.sender.document;

import com.company.service.AbstractService;
import com.company.variable.message.GeneralSender;
import com.company.variable.message.SenderMessage;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.company.variable.constants.UserLang.LANG_UZ;
import static com.company.variable.constants.UserMenu.*;
import static com.company.variable.constants.UserStep.STEP_MAIN_MENU;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:24 PM
 */

@Service
@Slf4j
public class DocumentServiceImpl extends AbstractService implements DocumentService {
    @Value("${api.map}")
    private String api;

    @Override
    public GeneralSender start(Long chatId, Message message) {
        return null;
    }

    @Override
    public GeneralSender location(Message message) {
        Long chatId = message.getChatId();

        var step = userService.getStep(chatId);
        if (!step.equals(STEP_MAIN_MENU)) return null;

        String location = getLocation(message);
        var lang = userService.getLang(chatId).equals(LANG_UZ);

        String yes = lang ? MENU_YES_UZ : MENU_YES_RU;
        String no = lang ? MENU_NO_UZ : MENU_NO_RU;
        String back = lang ? MENU_BACK_UZ : MENU_BACK_RU;

        var r1 = reply.getRowsWithText(no, yes);
        var r2 = reply.getRowsWithText(back);
        var keyboard = reply.getKeyboard(r1, r2);

        String msg = lang
                ? "Buyurtma bermoqchi bo`lgan manzilingiz: <b>" + location + "</b> tasdiqlaysizmi?"
                : "Адрес, по которому вы хотите заказать: <b>" + location + "</b> Вы подтверждаете этот адрес?";


        return SenderMessage
                .builder()
                .text(msg)
                .reply(keyboard)
                .parseMode(ParseMode.HTML)
                .chatId(chatId)
                .build();
    }

    private String getLocation(Message message) {
        var lat = message.getLocation().getLatitude();
        var lon = message.getLocation().getLongitude();
        RestTemplate res = new RestTemplate();
        var s = res
                .getForEntity("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&key=" + api, String.class);
        JSONObject object = new JSONObject(s.getBody());
        JSONArray array = new JSONArray(object.getJSONArray("results"));
        object = (JSONObject) array.get(4);
        var str = object.get("formatted_address");
        return str.toString();
    }
}




