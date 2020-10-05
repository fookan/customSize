package com.example.countchars.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomSizeValidator implements ConstraintValidator<CustomSize, String> {

  private int max;

  @Override
  public void initialize(CustomSize customSize) {
    max = customSize.max();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) { 
    System.out.println("**** CUSTOM VALIDATION ****");
    System.out.println(" SIZE = " + value.length());
    String text = value.replaceAll("[\r\n]", "");
    text = text.replaceAll("[\r]", "");
    System.out.println(text);
    System.out.println(" SIZE = " + text.length());
    return text.length() <= max;
  }
}