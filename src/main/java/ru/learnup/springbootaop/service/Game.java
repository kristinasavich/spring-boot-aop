package ru.learnup.springbootaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.springbootaop.service.eventnumber.EventNumberListener;
import ru.learnup.springbootaop.service.eventnumber.EventNumberPublisher;
import ru.learnup.springbootaop.service.speacker.Speacker;

import java.util.Scanner;

@Service
public class Game {

    //бесячая статик переменная инт для ген числа
    public static int genX;
    @Autowired
    private Speacker speacker;
    @Autowired
    private EventNumberListener eventNumberListener;
    @Autowired
    private EventNumberPublisher eventNumberPublisher;

    public Game(){}
    public Game(int genX){
        this.genX = genX;
    }

    @WorkTime
    public void start(){
        //вызов реплик из класса Speacker
        speacker.saySpeacker(1);
        speacker.saySpeacker(2);
        //генерация числа
        genX = 0 + (int) (Math.random() * 1000);
        //создаём слушатель для цикла
        while (!eventNumberListener.getIsFind()) {
            //ввод и создание события в цикле publisher.publishNumber(new Scanner(System.in).nextInt());
            eventNumberPublisher.publishNumber(new Scanner(System.in).nextInt());
        }
    }



}
