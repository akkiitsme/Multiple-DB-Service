package com.multipledb.transaction.user;

import com.multipledb.lookup.country.CountryDao;
import com.multipledb.transaction.config.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    CountryDao countryDao;

    @Autowired
    RequestContext requestContext;

    @GetMapping("/user-list")
    public ResponseEntity<?> getUser(HttpServletRequest request){
        requestContext.setCurrentTenantIdentifier("tenant1");
        System.out.println(countryDao.findAll());
      return new ResponseEntity<List<UserBean>>(userDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
        return new ResponseEntity<UserBean>(userDao.findByUserId(userId), HttpStatus.OK);
    }

}
