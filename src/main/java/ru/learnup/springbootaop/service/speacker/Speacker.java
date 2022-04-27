package ru.learnup.springbootaop.service.speacker;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static ru.learnup.springbootaop.service.Game.genX;

@Component
public class Speacker {
    private MessageSource messageSource;

    public Speacker(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //instructions
    public void saySpeacker(int x) {
        switch (x) {
            case 1:
                //Привет, я загадал число, попробуй его отгадать!
                System.out.println(messageSource.getMessage("hello", null, Locale.getDefault()));
                break;
            case 2:
                //Делай попытку, можно вводить числа от 0 до 1000!
                System.out.println(messageSource.getMessage("gogame", null, Locale.getDefault()));
                break;
            case 3:
                //Мое число побольше твоего
                System.out.println(messageSource.getMessage("numberbigger", null, Locale.getDefault()));
                break;
            case 4:
                //Мое число меньше твоего
                System.out.println(messageSource.getMessage("numberless", null, Locale.getDefault()));
                break;
            case 5:
                //Ты угадал, я загадал число Х
                System.out.println(messageSource.getMessage("win", null, Locale.getDefault()) + " " + genX);
                break;
        }

    }
}
