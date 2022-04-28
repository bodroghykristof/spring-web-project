package hu.vemsoft.web.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class makes accessible the ApplicationContext which is assigned to its static
 * variable named CONTEXT. This class implements an interface called ApplicationContextAware
 * which is an interface to be implemented by any object that wishes to be notified of the
 * ApplicationContext that it runs in.
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    public static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        CONTEXT = applicationContext;
    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}