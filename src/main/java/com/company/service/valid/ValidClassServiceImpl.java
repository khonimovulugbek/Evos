package com.company.service.valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:04 PM
 */

@Service
@Slf4j
public class ValidClassServiceImpl implements ValidClassService {

    @Override
    public boolean isFormative(Class<?> className, String text) {

        Field[] declaredFields = className.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                if (text.equals(declaredField.get(declaredField.getName()).toString())) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                log.warn(className.getName() + " -> " + e.getMessage());
            }
        }
        return false;
    }
}




