package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{



	UserEntity findByEmail(String email);

	UserEntity findByEmailAndPassword(String email, String password);

//	UserEntity findByOtpAndPassword(Integer otp, String password);

	UserEntity findByOtp(Integer otp);

}
