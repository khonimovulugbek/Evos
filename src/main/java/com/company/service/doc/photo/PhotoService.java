package com.company.service.doc.photo;

import org.telegram.telegrambots.meta.api.objects.InputFile;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:03 PM
 */

public interface PhotoService {
    InputFile getInputFileByUrl(String url, String fileName, String ext);
}
