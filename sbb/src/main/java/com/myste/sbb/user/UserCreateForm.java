package com.myste.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateForm {
	
	@Size(min=3, max=25)
	@NotEmpty(message= "사용자 아이디는 필수 입력 항목입니다.")
	private String username;
	
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	private String password;
	
	@NotEmpty(message = "비밀번호 확인은 필수 항목입니다.")
	private String password2;
	
	@NotEmpty(message = "이메일은 필수 입력 항목입니다.")
	@Email
	private String email;

	
	
	
}
