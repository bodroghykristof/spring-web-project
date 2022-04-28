package hu.vemsoft.web.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy // hint: toggle this annotation and check the order of logs printed by SpringApplicationStartupListener
public class LazyService {

    @PostConstruct
    public void init() {
        System.out.println("LazyService initialized!");
    }

}
