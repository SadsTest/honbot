package ru.hon.honbot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

@CrossOrigin
@RestController
public class RestControllerForCron {

    @GetMapping
    public String getMain(){
        return "Hello world!";
    }
}
