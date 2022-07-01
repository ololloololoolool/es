package com.library.form.mo;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginMO {

	@NotBlank
	private String nick;
	
	@NotBlank
	private String password;
	
}
