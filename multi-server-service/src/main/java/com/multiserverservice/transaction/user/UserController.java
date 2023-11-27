package com.multiserverservice.transaction.user;

import com.multiserverservice.lookup.country.CountryDao;
import com.multiserverservice.lookup.culture.CultureBean;
import com.multiserverservice.lookup.culture.CultureDao;
import com.multiserverservice.transaction.config.RequestContext;
import com.multiserverservice.transaction.verification.MobileVerDao;
import com.multiserverservice.transaction.verification.MobileVerificationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    CountryDao countryDao;

    @Autowired
    CultureDao cultureDao;

    @Autowired
    UserDao userDao;

    @Autowired
    MobileVerDao mobileVerDao;

    @Autowired
    RequestContext requestContext;

    @RequestMapping("/helloUS")
    public ResponseEntity<?> getDetails(){
        requestContext.setCurrentSourceIdentifier("US");
        System.out.println(cultureDao.findByCultureId(4));
        System.out.println(userDao.findByPanelistId(11645970));
        System.out.println(countryDao.findByCountryId(102));
        System.out.println(userDao.findByPanelistId(11645970));
        System.out.println(userDao.findByPanelistId(11645970));
        return new ResponseEntity<List<MobileVerificationBean>>(mobileVerDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/helloUK")
    public ResponseEntity<?> getFurtherDetails(){
        requestContext.setCurrentSourceIdentifier("UK");
        System.out.println(cultureDao.findByCultureId(2));
        System.out.println(userDao.findByPanelistId(11645970));
        System.out.println(countryDao.findByCountryId(102));
        return new ResponseEntity<PanelistBean>(userDao.findByPanelistId(11645970), HttpStatus.OK);
    }

    @RequestMapping("/hello")
    public ResponseEntity<?> getSomethingDetails(){
        System.out.println(cultureDao.findByCultureId(1));
        System.out.println(userDao.findByPanelistId(11645970));
        System.out.println(countryDao.findByCountryId(102));
        return new ResponseEntity<CultureBean>(cultureDao.findByCultureId(1), HttpStatus.OK);
    }

}
