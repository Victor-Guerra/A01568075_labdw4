package mx.tec.web.lab.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * Color Validator Class 
 * @author victorg
 *
 */
public class ColorValidator implements ConstraintValidator<ValidColor, String> {
	private final List<String> validColors = Arrays.asList("Black", "LightBlue" , "SeaBlue", "DarkStonewash", "DarkBlue");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for(String validColor: validColors) {
			if (validColor.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

}
