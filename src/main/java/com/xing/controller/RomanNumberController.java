package com.xing.controller;

import com.xing.entity.Result;
import com.xing.service.RomanNumberService;
import com.xing.util.exception.InvalidNumberException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanNumberController {

    @Autowired
    RomanNumberService service;

    @Autowired
    Logger logger;

    @GetMapping("/romannumeral")
    public Result getRamanNumber(@RequestParam("query") Integer number) throws InvalidNumberException {
//        System.out.println(number);
        logger.debug(String.format("Input query = %d", number));
        Map<String, Object> map = new HashMap<>();
        map.put("input", number);
        String output = service.getRomanNumber(number);
        logger.debug(String.format("Output string = %s", output));
        map.put("output", output);
        return new Result(true, 200, "Success", map);
    }
}
