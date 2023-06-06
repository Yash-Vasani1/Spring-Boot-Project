package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bean.UserBean;
import com.Entity.UserEntity;
import com.Entity.resetentity;
import com.Repository.UserRepository;
import com.service.TokenGenerator;
@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	TokenGenerator tkgen;
	
	@PostMapping("/SignUp")
	public ResponseEntity<UserBean<UserEntity>> SignUp(@RequestBody UserEntity user)
	{
		UserEntity tempUser = userrepo.findByEmail(user.getEmail());
		UserBean<UserEntity> tUser = new UserBean<>();
		if(tempUser == null) {
			userrepo.save(user);
			tUser.setData(user);
			tUser.setMsg("User Data Added Sucessfully !!");
		}
		else
		{
			tUser.setData(tempUser);
			tUser.setMsg("User Already Exist !!");
		}
		return ResponseEntity.ok(tUser);
	}
	
	@GetMapping("/Login")
	public ResponseEntity<UserBean<UserEntity>> Login(@RequestParam("email") String email, @RequestParam("password") String password)
	{
		UserEntity tempUserByEmail = userrepo.findByEmail(email);
		UserEntity tempuser = userrepo.findByEmailAndPassword(email,password);
		UserBean<UserEntity> usr = new UserBean<>();
		if(tempUserByEmail == null || tempuser == null)
		{
			usr.setData(null);
			usr.setMsg("You can try ForgotPassword !!");
			return ResponseEntity.ok(usr);
		}
		else
		{
			String token = tkgen.generateToken(7);
			tempuser.setToken(token);
			userrepo.save(tempuser);
			
			usr.setData(tempuser);
			usr.setMsg("Sucessfully login !!");
			return ResponseEntity.ok(usr);
		}
	}
	
	@GetMapping("/forgotPassword")
	public ResponseEntity<UserBean<UserEntity>> forgotPasseord(@RequestParam("email") String email){
		UserEntity tempUserByEmail = userrepo.findByEmail(email);
		UserBean<UserEntity> usr = new UserBean<>();
		if(tempUserByEmail == null)
		{
			usr.setData(null);
			usr.setMsg("Otp will share to your Email, if email is exists !!");
			return ResponseEntity.ok(usr);
		}
		else
		{
			Integer min = 100000;
			Integer max = 999999;
			Integer temp = (int) (Math.random() * (max - min + 1) + min)  ;
			System.out.println("-----------------"+temp+"-----------------");
			tempUserByEmail.setOtp(temp);
			userrepo.save(tempUserByEmail);
			usr.setData(tempUserByEmail);
			usr.setMsg("Otp will share to your Email, if email is exists (OTP set)!!");
			return ResponseEntity.ok(usr);
		}
	}
	
	@GetMapping("/ResetPassword")
	public ResponseEntity<UserBean<UserEntity>> resetPassword(@RequestParam("otp") Integer otp, @RequestParam("password") String password, @RequestParam("conformpassword") String conformpassword)
	{
		UserEntity user = userrepo.findByOtp(otp);
			if((password.equals(conformpassword)) && !(user.getPassword().equals(password)))
			{
				UserBean<UserEntity> usr = new UserBean<>();
				user.setPassword(conformpassword);
				userrepo.save(user);
				usr.setData(user);
				usr.setMsg("Password sucessfully reset !!");
				return ResponseEntity.ok(usr);
			}
			else
			{
				UserBean<UserEntity> usr = new UserBean<>();
				usr.setData(null);
				usr.setMsg("Please enter password and conformpassword same !!");
				return ResponseEntity.ok(usr);
			}
		}
	}
