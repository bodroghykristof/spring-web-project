package hu.vemsoft.web.repository;

import hu.vemsoft.web.model.User;
import hu.vemsoft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
// @DependsOn("userService")
// If this dummy annotation was left here Spring would not be able to set up the application context because of
// having a circular dependency. Error message:
// Error creating bean with name 'userService': Requested bean is currently in creation:
// Is there an unresolvable circular reference?
public class UserRepository {

    public List<User> findAll() {
        return Arrays.asList(new User("Chris", "admin"),
                new User("Johnny", "manager"));
    }

}
