package hu.vemsoft.web.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * This is the preferred way to use a different instance of a prototype bean on each method call opposed
 * using ApplicationContext.getBean() method call which couples our code to the Spring framework
 */
@Component
public abstract class AbstractPrototypeUsageService {

    public void usePrototypeService() {
        PrototypeService service = createPrototypeService();
        System.out.println(service.hashCode());
    }

    @Lookup
    // this annotation tells Spring to override this method and create an implementation
    // which returns a new instance of the given prototype bean of the returned type of this method
    protected abstract PrototypeService createPrototypeService();

}
