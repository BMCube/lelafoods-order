package edu.miu.lelafoods.order;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        rabbitAdmin.initialize();
    }
}
