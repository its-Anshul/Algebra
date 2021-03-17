package com.beehyv.algebra_services;

import com.beehyv.algebra_services.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AlgebraServicesController {

	@Autowired
	private AlgebraServicesService algebraServicesService;

	@GetMapping("/calculate")
    	public ResponseEntity<Object> calculateEquation(@RequestParam("UserId") String userId, @RequestParam("equation") String equation) {
        try
        {
            return new ResponseEntity<>(algebraServicesService.calculateEquation(userId,equation), HttpStatus.OK);
        }catch(Exception ex)
        {
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	}
	
	@GetMapping("/userchoice")
    	public ResponseEntity<Object> getUserChoice(@RequestParam("UserId") String userId) {
        try
        {
            return new ResponseEntity<>(algebraServicesService.getUserChoice(userId), HttpStatus.OK);
        }catch(Exception ex)
        {
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	}
}