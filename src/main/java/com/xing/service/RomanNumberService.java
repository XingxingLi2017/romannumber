package com.xing.service;

public interface RomanNumberService {
    /**
     * This method is used to convert a given integer to roman number string.
     * @param number  the integer in range [1, 3999]
     * @return a string representing the number in roman number format
     */
    String getRomanNumber(Integer number);
}
