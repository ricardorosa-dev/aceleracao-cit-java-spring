package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.math.BigDecimal;
import java.lang.reflect.Field;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) throws IllegalArgumentException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;

        Field[] allFields = object.getClass().getDeclaredFields();
        for (Field field : allFields) {
//            if (field.getAnnotatedType() instanceof BigDecimal) {
//                if (field.getAnnotations().equals(Somar.class)) {
//                if (field.getType().getName().equals(BigDecimal.class.getName())) {
            if (field.isAnnotationPresent(Somar.class)) {
                    field.setAccessible(true);
                    result = result.add((BigDecimal) field.get(object));
//                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal subtrair(Object object) throws IllegalArgumentException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;

        Field[] allFields = object.getClass().getDeclaredFields();
        for (Field field : allFields) {
//            if (field.getAnnotatedType() instanceof BigDecimal) {
//                if (field.getAnnotations().equals(Subtrair.class)) {
    //                if (field.getType().getName().equals(BigDecimal.class.getName())) {
                if (field.isAnnotationPresent(Subtrair.class)) {
                        field.setAccessible(true);
                        result = result.add((BigDecimal) field.get(object));
//                }
//                }
            }
        }
        return result;
    }
    @Override
    public BigDecimal totalizar(Object object) throws IllegalArgumentException, IllegalAccessException {
        BigDecimal result = BigDecimal.ZERO;
        result.add(somar(object));
        result.subtract(subtrair(object));

        return result;
    }

}