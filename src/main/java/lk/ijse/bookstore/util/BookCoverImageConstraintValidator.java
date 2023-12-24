package lk.ijse.bookstore.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class BookCoverImageConstraintValidator implements ConstraintValidator<BookCoverImage, MultipartFile> {
    private long maximumFileSize;

    @Override
    public void initialize(BookCoverImage constraintAnnotation) {
        maximumFileSize = constraintAnnotation.maximumFileSize();
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        if(multipartFile.isEmpty()) return true;
        if(multipartFile.getSize() > maximumFileSize) return false;
        if(multipartFile.getContentType() == null) return false;
        if(!multipartFile.getContentType().startsWith("image/")) return false;
        return true;
    }
}
