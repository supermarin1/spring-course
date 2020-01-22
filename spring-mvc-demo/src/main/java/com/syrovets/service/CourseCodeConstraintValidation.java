package com.syrovets.service;

import com.syrovets.custom.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidation implements ConstraintValidator<CourseCode, String> {
   private String coursePrefix;

   public void initialize(CourseCode courseCode) {
      coursePrefix = courseCode.value();
   }

   public boolean isValid(String code, ConstraintValidatorContext context) {
      boolean result;
      if (code != null) {
         result = code.startsWith(coursePrefix);
      } else {
         result = true;
      }
      return result;
   }
}
