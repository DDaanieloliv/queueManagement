package ddaaniel.io.queueManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class QueueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueManagementApplication.class, args);
	}

}
