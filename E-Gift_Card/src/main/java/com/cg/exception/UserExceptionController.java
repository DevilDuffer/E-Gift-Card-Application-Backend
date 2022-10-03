package com.cg.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> exception(UserNotFoundException e){
		return new ResponseEntity("User Not Found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = GiftCardNotFoundException.class)
	public ResponseEntity<String> exception(GiftCardNotFoundException e){
		return new ResponseEntity("Gift Card Not Found",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = UserGiftDetailsNotFoundException.class)
	public ResponseEntity<String> exception(UserGiftDetailsNotFoundException e){
		return new ResponseEntity("User Gift Details Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PaymentNotFoundException.class)
	public ResponseEntity<String> exception(PaymentNotFoundException e){
		return new ResponseEntity("Payment Details Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = GiftRecdDetailsNotFoundException.class)
	public ResponseEntity<String> exception( GiftRecdDetailsNotFoundException e){
		return new ResponseEntity("GiftRecd Details Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
}
      