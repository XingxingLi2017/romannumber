package com.xing.service;

import com.xing.util.exception.InvalidNumberException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RomanNumberServiceTest {
    @Autowired
    private RomanNumberService service;

    @Test
    public void testGetRomanNumberNormal() {
        Assert.assertEquals("XXXVI", service.getRomanNumber(36));
    }

    @Test(expected = InvalidNumberException.class)
    public void testGetRomanNumberNegative() {
        service.getRomanNumber(-1);
    }

    @Test(expected = InvalidNumberException.class)
    public void testGetRomanNumberOutOfRange() {
        service.getRomanNumber(40000);
    }
}