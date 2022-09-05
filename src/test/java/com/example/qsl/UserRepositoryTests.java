package com.example.qsl;

import com.example.qsl.user.entity.SiteUser;
import com.example.qsl.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@Transactional을 붙이면 각 케이스테이블에 전부 @트Transactional 쓴 것과 동일
//@Test+@Transactional 조합은 자동으로 롤백을 유발시킨다.
@Transactional
@ActiveProfiles("test") //테스트 모드 활성화
class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	@DisplayName("회원 생성")
	void t1() {

		SiteUser u1 = new SiteUser(null, "user1", "{noop}1234","user1@test.com");
		SiteUser u2 = SiteUser.builder()
				.username("user2")
				.password("{noop}1234")
				.email("user2@test.com")
				.build();
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	@Test
	@DisplayName("1번 회원을 Qsl로 가져오기")
	void t2() {
		SiteUser u1 = userRepository.getQslUser(1L);

		assertThat(u1.getId()).isEqualTo(1L);
		assertThat(u1.getUsername()).isEqualTo("user1");
		assertThat(u1.getEmail()).isEqualTo("user1@test.com");
		assertThat(u1.getPassword()).isEqualTo("{noop}1234");
	}

}
