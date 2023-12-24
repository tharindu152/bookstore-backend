package lk.ijse.bookstore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public Bucket defaultBucket() throws IOException {
		InputStream serviceAccount = getClass().getResourceAsStream("/online-bookstore-2b94e-firebase-adminsdk-pr0bx-b85501c0a7.json");

		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setStorageBucket("online-bookstore-2b94e.appspot.com")
				.build();
		FirebaseApp.initializeApp(options);
		return StorageClient.getInstance().bucket();
	}
}
