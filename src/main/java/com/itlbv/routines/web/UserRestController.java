package com.itlbv.routines.web;

import com.itlbv.routines.model.User;
import com.itlbv.routines.service.UserService;
import com.itlbv.routines.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserRestController {
    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

    private final UserService service;

    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }

    public User create(User user) {
        ValidationUtil.checkNew(user);
        log.info("create {}", user);
        return service.create(user);
    }

    public void update(User user, int id) {
        ValidationUtil.checkIdConsistency(user, id);
        log.info("update {}", user);
        service.update(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }
}
