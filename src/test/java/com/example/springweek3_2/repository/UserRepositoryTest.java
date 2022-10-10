package com.example.springweek3_2.repository;

import com.example.springweek3_2.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Order(1)
    @Test
    public void create() {
        // 회원 "user1" 객체 생성
        User instance1 = new User("user1", "정국", "불족발");
        // 회원 "user1" 객체 또 생성
        User instance2 = new User("user1", "정국", "불족발");
        assert(instance2 != instance1);
        // 회원 "user1" 객체 또또 생성
        User instance3 = new User("user1", "정국", "불족발");
        assert(instance3 != instance2);

        // 회원 "user1" 객체 추가
        User user1 = new User("user1", "정국", "불족발");

        // 회원 "user1" 객체의 ID 값이 없다가..
        userRepository.save(user1);

        // 테스트 회원 데이터 삭제
        userRepository.delete(user1);
    }

    @Order(2)
    @Test
    public void findUser() {
        // ------------------------------------
        // 회원 "user1" 객체 추가
        User beforeSavedUser = new User("user1", "정국", "불족발");

        // 회원 "user1" 객체를 영속화
        User savedUser = userRepository.save(beforeSavedUser);

        // 회원 "user1" 을 조회
        User foundUser1 = userRepository.findById("user1").orElse(null);
        assert(foundUser1 != savedUser);

        // 회원 "user1" 을 또 조회
        User foundUser2 = userRepository.findById("user1").orElse(null);
        assert(foundUser2 != savedUser);

        // 회원 "user1" 을 또또 조회
        User foundUser3 = userRepository.findById("user1").orElse(null);
        assert(foundUser3 != savedUser);

        // ------------------------------------
        // 테스트 회원 데이터 삭제
        userRepository.delete(beforeSavedUser);
    }

    @Order(3)
    @Test
    public User updateUser1() {
        // 테스트 회원 "user1" 생성
        User user = new User("user1", "RM", "고기");
        // 회원 "user1" 객체를 영속화
        User savedUser1 = userRepository.save(user);

        // 회원의 nickname 변경
        savedUser1.setNickname("남준이");
        // 회원의 favoriteFood 변경
        savedUser1.setFavoriteFood("육회");

        // user1 을 저장
        User savedUser2 = userRepository.save(savedUser1);
        assert(savedUser1 == savedUser2);

        return savedUser2;
    }
}