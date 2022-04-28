package hu.vemsoft.web.service;

import hu.vemsoft.web.model.User;
import hu.vemsoft.web.repository.BillingDataRepository;
import hu.vemsoft.web.repository.UserAccountRepository;
import hu.vemsoft.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // we could also use @Autowired here
    private UserRepository userRepository;
    private UserAccountRepository accountRepository;
    private Optional<BillingDataRepository> billingDataRepository;

    public UserService() {
    }

    /**
     * We only need @Autowired annotation here if the no args constructor is present.
     * In case of a single constructor Spring finds and uses it by default.
     *
     * BillingDataRepository is an optional dependency of UserService. In this exact context there is no bean
     * defined with this type, so optional is empty (see: init method)
     *
     */
    @Autowired
    public UserService(UserRepository userRepository, Optional<BillingDataRepository> billingDataRepository) {
        this.userRepository = userRepository;
        this.billingDataRepository = billingDataRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Here we define an optional dependency (not required)
     * Rule of thumb: use optional dependencies in setters and required ones in constructors
     */
    @Autowired(required = false)
    public void setAccountRepository(UserAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostConstruct
    public void init() {
        List<User> users = findAll();
        // users.forEach(System.out::println);
        System.out.println(billingDataRepository.isPresent());
    }

}
