package ru.learnup.springbootaop.service.eventnumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnup.springbootaop.service.Game;
import ru.learnup.springbootaop.service.LogMethod;
import ru.learnup.springbootaop.service.WorkTime;
import ru.learnup.springbootaop.service.speacker.Speacker;

@Component
public class EventNumberListener implements ApplicationListener<EventNumber> {
    private boolean isFind;
    @Autowired
    private Speacker speacker;

    @Override
    public void onApplicationEvent(EventNumber event) {
        //число из слушателя сравниваем с импорт статик инт гейм
        //на каждый результат вызываем метод c фразами
        if (event.getNumber() == Game.genX) {
            speacker.saySpeacker(5);

            setFind(true);
        } else if (event.getNumber() > Game.genX) {
            speacker.saySpeacker(4);
        } else if (event.getNumber() < Game.genX) {
            speacker.saySpeacker(3);
        }
    }

    @LogMethod
    public boolean getIsFind() {
        return isFind;
    }

    @WorkTime
    public void setFind(boolean isFind) {
        this.isFind = isFind;
    }}
