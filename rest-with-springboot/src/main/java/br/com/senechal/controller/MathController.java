package br.com.senechal.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.senechal.exception.UnsupportedMathOperation;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne,
							 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperation("Please set a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
		
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value="numberOne") String numberOne,
							 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperation("Please set a numeric value!");
		}
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtraction;
		
	}	
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value="numberOne") String numberOne,
							 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperation("Please set a numeric value!");
		}
		Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiplication;
		
	}	
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable(value="numberOne") String numberOne,
							 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperation("Please set a numeric value!");
		} else if (numberTwo == "0"){
			//division by 0
			throw new UnsupportedMathOperation("It is not possible to divide by 0!");
		}
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
		
	}	

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
