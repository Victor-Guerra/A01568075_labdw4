package mx.tec.web.lab.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = ColorValidator.class)
/**
 * Valid Color Interface
 * @author victorg
 *
 */
public @interface ValidColor {
	/**
	 * Default message
	 * @return default message
	 */
	String message() default "Invalid Color";

	/**
	 * Default Group
	 * @return default group
	 */
	Class<?>[] groups() default {};

	/**
	 * Default Payload
	 * @return default payload
	 */
	Class<? extends Payload>[] payload() default {};
}
