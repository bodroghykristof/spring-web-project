package hu.vemsoft.web.repository;

import org.springframework.stereotype.Component;

/**
 * This is just a simple Java class (not a Java bean) created to simulate optional dependencies in UssrService
 */
@Component // hint: toggle this line as commented and uncommented and see the logging in UserService.init()!
public class BillingDataRepository {

    public BillingDataRepository() {
    }

}
