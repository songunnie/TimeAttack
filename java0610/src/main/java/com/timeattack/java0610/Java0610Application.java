package com.timeattack.java0610;

import com.timeattack.java0610.domain.User;
import com.timeattack.java0610.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Java0610Application {

	public static void main(String[] args) {
		SpringApplication.run(Java0610Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new User());

			List<User> userList = userRepository.findAll();
			for (int i=0; i<userList.size(); i++) {
				User user = userList.get(i);
				System.out.println(user.getEmail());
				System.out.println(user.getName());
				System.out.println(user.getAge());
				System.out.println(user.getGender());
			}

			User user = userRepository.findById(1L).orElseThrow(
					() -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다."));
		};
	}
}
