package com.multipledb.lookup.country;

import com.multipledb.transaction.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryDao countryDao;

    @GetMapping("/country-list")
    public ResponseEntity<?> getCountry(){
        return new ResponseEntity<List<CountryBean>>(countryDao.findAll(), HttpStatus.OK);
    }
}
