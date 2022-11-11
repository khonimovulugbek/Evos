package com.company;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Author : Khonimov Ulugbek
 * Date : 11.11.2022
 * Time : 3:44 PM
 */

public class Main {
    @Value("${api.map")
    static String a;

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=" + a, String.class);
    }

}




