package ru.learnup.springbootaop.service.eventnumber;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class EventNumberPublisher implements ApplicationContextAware {
    private ApplicationContext context;

    public void publishNumber(int numberGame){
        context.publishEvent(new EventNumber(numberGame));
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
