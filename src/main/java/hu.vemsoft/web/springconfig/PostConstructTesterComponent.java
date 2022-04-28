package hu.vemsoft.web.springconfig;

import hu.vemsoft.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * This class was created to test some Spring features in its @PostConstruct method
 */
@Component
@DependsOn("springApplicationContext")
public class PostConstructTesterComponent {

    @PostConstruct
    public void init() {
        // IMPORTANT! to access the context we need to declare the dependency between the two beans via @DependsOn
        // otherwise we would get a NullPointerException
        ApplicationContext context = SpringApplicationContext.CONTEXT;
        UserService userServiceBean = (UserService) SpringApplicationContext.getBean("userService");
        // System.out.println(userServiceBean.findAll().size());
    }
}