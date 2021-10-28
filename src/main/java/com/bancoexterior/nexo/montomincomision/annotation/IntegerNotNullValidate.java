package com.bancoexterior.nexo.montomincomision.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerNotNullValidate implements 
ConstraintValidator<AIntegerNotNullValidate, Integer> {

	
  @Override
  public void initialize(AIntegerNotNullValidate number) {
	//
  }

  @Override
  public boolean isValid(Integer numero, final ConstraintValidatorContext cvc) {
 
	  return (numero != null);
	 
  }

}
