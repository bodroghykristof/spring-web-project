package hu.vemsoft.web.springconfig;

import hu.vemsoft.web.service.AbstractPrototypeUsageService;
import hu.vemsoft.web.service.LazyService;
import hu.vemsoft.web.service.PrototypeService;
import hu.vemsoft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for running logic right after the application context has been set up.
 */
@Component
public class SpringApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AbstractPrototypeUsageService abstractPrototypeUsageService;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        UserService userServiceBean = (UserService) SpringApplicationContext.getBean("userService");
         System.out.println(userServiceBean.findAll().size());
        // post construct method is only called here as this bean is defined as a lazy bean
        LazyService lazyService = (LazyService) SpringApplicationContext.getBean("lazyService");
        // investigatePrototypeBehavior();
        // investigatePrototypeBehaviorWithLookup();
    }

    private void investigatePrototypeBehavior() {
        // see the logs of instantiating prototype bean each time
        // see hash codes as well: 3 different objects are created!
        // when this method is commented out the prototype bean is not initialized at all
        PrototypeService prototypeServiceOne = (PrototypeService) SpringApplicationContext.getBean("prototypeService");
        System.out.println(prototypeServiceOne.hashCode());
        PrototypeService prototypeServiceTwo = (PrototypeService) SpringApplicationContext.getBean("prototypeService");
        System.out.println(prototypeServiceTwo.hashCode());
        PrototypeService prototypeServiceThree = (PrototypeService) SpringApplicationContext.getBean("prototypeService");
        System.out.println(prototypeServiceThree.hashCode());

        // note: THIS IS BAD PRACTICE as it couples the class to the Spring DI container
        // better approach is Lookup Method Injection see: AbstractPrototypeUsageService and the method below this
    }
    private void investigatePrototypeBehaviorWithLookup() {
        abstractPrototypeUsageService.usePrototypeService();
        abstractPrototypeUsageService.usePrototypeService();
        abstractPrototypeUsageService.usePrototypeService();
    }
}
