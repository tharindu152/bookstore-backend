package lk.ijse.bookstore.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO {

    private MultipartFile profileImage;
}
