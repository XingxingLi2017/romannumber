package com.xing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "roman-number-units")
public class RomanUnitProps {
    List<String> X;
    List<String> M;
    List<String> C;
    List<String> I;

    public List<String> getX() {
        return X;
    }

    public void setX(List<String> x) {
        X = x;
    }

    public List<String> getM() {
        return M;
    }

    public void setM(List<String> m) {
        M = m;
    }

    public List<String> getC() {
        return C;
    }

    public void setC(List<String> c) {
        C = c;
    }

    public List<String> getI() {
        return I;
    }

    public void setI(List<String> i) {
        I = i;
    }
}
