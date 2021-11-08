package com.xing.controller;

import com.xing.entity.Result;
import com.xing.service.RomanNumberService;
import com.xing.util.exception.InvalidNumberException;
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

    @GetMapping("/romannumeral")
    public Result getRamanNumber(@RequestParam("query") Integer number) throws InvalidNumberException {
        System.out.println(number);
        Map<String, Object> map = new HashMap<>();
        map.put("input", number);
        map.put("output", service.getRomanNumber(number));
        return new Result(true, 200, "Success", map);
    }
}
