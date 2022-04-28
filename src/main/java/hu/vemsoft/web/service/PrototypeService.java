package hu.vemsoft.web.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeService {

    private static Integer INIT_COUNTER = 0;

    @PostConstruct
    public void init() {
        INIT_COUNTER ++;
        System.out.println("PrototypeService initiated " + INIT_COUNTER + " times");
    }
}
