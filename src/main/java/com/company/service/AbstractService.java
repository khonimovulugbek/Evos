package com.company.service;

import com.company.service.doc.photo.PhotoService;
import com.company.service.keyboard.inline.InlineKeyboardService;
import com.company.service.keyboard.reply.ReplyKeyboardService;
import com.company.service.user.UserService;
import com.company.service.valid.ValidClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 12:42 PM
 */
@Slf4j
abstract public class AbstractService {
    @Autowired
    protected UserService userService;
    @Autowired
    protected InlineKeyboardService inline;
    @Autowired
    protected ReplyKeyboardService reply;
    @Autowired
    protected PhotoService photoService;
    @Autowired
    protected ValidClassService valid;
}




