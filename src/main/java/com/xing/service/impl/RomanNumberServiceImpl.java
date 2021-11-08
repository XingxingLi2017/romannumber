package com.xing.service.impl;

import com.xing.config.RomanUnitProps;
import com.xing.service.RomanNumberService;
import com.xing.util.exception.InvalidNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
public class RomanNumberServiceImpl implements RomanNumberService {

    @Autowired
    RomanUnitProps units;

    @Override
    public String getRomanNumber(Integer number) throws InvalidNumberException {
        if(number < 1 || number > 3999)
            throw new InvalidNumberException("The input number is valid integer in range [1, 3999]");
        return units.getM().get(number/1000)
                + units.getC().get((number % 1000) / 100)
                + units.getX().get((number % 100) / 10)
                + units.getI().get(number % 10);
    }
}
