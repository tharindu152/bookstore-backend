package lk.ijse.bookstore.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookCoverImageConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)

public @interface BookCoverImage {

    long maximumFileSize() default (1000*1024);
    String message() default "Invalid image or size exceeds more than 1MB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}



