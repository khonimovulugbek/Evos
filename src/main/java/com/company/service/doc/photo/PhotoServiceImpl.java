package com.company.service.doc.photo;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:03 PM
 */

@Service
public class PhotoServiceImpl implements PhotoService {

    @Override
    public InputFile getInputFileByUrl(String url, String fileName, String ext) {

        byte[] imageInByte;
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            imageInByte = in.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStream is = new ByteArrayInputStream(imageInByte);
        InputFile inputFile = new InputFile();
        inputFile.setMedia(is, fileName + "." + ext);
        return inputFile;
    }
}




