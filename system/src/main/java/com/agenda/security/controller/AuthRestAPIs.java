package com.agenda.security.controller;

import com.agenda.model.entity.Account;
import com.agenda.model.entity.Role;
import com.agenda.model.entity.RoleName;
import com.agenda.model.repository.AccountRepository;
import com.agenda.model.repository.RoleRepository;
import com.agenda.security.jwt.JwtProvider;
import com.agenda.security.request.LoginForm;
import com.agenda.security.request.SignUpForm;
import com.agenda.security.response.JwtResponse;
import com.agenda.security.response.ResponseMessage;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AccountRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody Account loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	/*
	TODO:
		 */
	@PostMapping("/signup")
	public ResponseEntity <?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername( signUpRequest.getUsername() )) {
			return new ResponseEntity <>( new ResponseMessage( "Fail -> Username is already taken!" ),
					HttpStatus.BAD_REQUEST );
		}

		if (userRepository.existsByEmail( signUpRequest.getEmail() )) {
			return new ResponseEntity <>( new ResponseMessage( "Fail -> Email is already in use!" ),
					HttpStatus.BAD_REQUEST );
		}

		// Creating user's account
		Account user = new Account( signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode( signUpRequest.getPassword()), signUpRequest.getDeleteFlag(), signUpRequest.getContacts());

		Set <String> strRoles = signUpRequest.getRole();
		Set <Role> roles = new HashSet <>();

		strRoles.forEach( role -> {
			switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName( RoleName.ROLE_ADMIN )
							.orElseThrow( () -> new RuntimeException( "Fail! -> Cause: User Role not find." ) );
					roles.add( adminRole );

					break;
				case "pm":
					Role pmRole = roleRepository.findByName( RoleName.ROLE_PM )
							.orElseThrow( () -> new RuntimeException( "Fail! -> Cause: User Role not find." ) );
					roles.add( pmRole );

					break;
				default:
					Role userRole = roleRepository.findByName( RoleName.ROLE_USER )
							.orElseThrow( () -> new RuntimeException( "Fail! -> Cause: User Role not find." ) );
					roles.add( userRole );
			}
		} );

		user.setRoles( roles );
		userRepository.save( user ).toAccountDto();

		return new ResponseEntity <>( new ResponseMessage( "User registered successfully!" ), HttpStatus.OK );
	}
}