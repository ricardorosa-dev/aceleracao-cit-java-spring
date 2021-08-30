package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    public BigDecimal somar(Object object) throws IllegalArgumentException, IllegalAccessException;
    public BigDecimal subtrair(Object object) throws IllegalArgumentException, IllegalAccessException;
    public BigDecimal totalizar(Object object) throws IllegalArgumentException, IllegalAccessException;
}