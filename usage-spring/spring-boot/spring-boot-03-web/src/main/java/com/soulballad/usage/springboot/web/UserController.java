package com.soulballad.usage.springboot.web;

import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/5/20 19:15
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userService.selectAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User user, UriComponentsBuilder builder) {
        if ("duplicated".equals(user.getName())) {
            LOGGER.warn("the user already exist");
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }

        userService.addUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/get/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
