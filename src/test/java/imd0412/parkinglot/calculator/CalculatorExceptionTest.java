package imd0412.parkinglot.calculator;

import org.junit.Test;

import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

public class CalculatorExceptionTest {
	
	//All out of boundary limits that throw Exception at checkin
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Day_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.00 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Month_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.00.01 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Year_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1969.01.01 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Day_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.32 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Month_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.13.31 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Year_Checkin() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2019.01.01 12:30", "2018.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}

	@Test(expected = InvalidDataException.class)
	public void Non_Existent_Checkin() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2018.04.31 12:30", "2018.05.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Non_Leap_29Feb_Checkin() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2015.02.29 12:30", "2015.03.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = DateFormatException.class)
	public void Wrong_Input_Format_Checkin() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2015.02.28 12:30min", "2015.03.01 12:30", ParkingLotType.ShortTerm);
		} catch (DateFormatException e) {
			throw e;
		}
	}
	

	//All out of boundary limits that throw Exception at checkout 
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Day_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.01 12:30", "1970.01.00 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Month_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.01 12:30", "1970.00.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Lower_Than_Limit_Year_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.01 12:30", "1969.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}

	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Day_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.01 12:30", "1970.01.32 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}

	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Month_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.12.31 12:30", "1970.13.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Higher_Than_Limit_Year_Checkout() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("1970.01.01 12:30", "2020.01.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
    
	@Test(expected = InvalidDataException.class)
	public void Non_Existent_Checkout() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2018.04.30 12:30", "2018.04.31 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}

	@Test(expected = InvalidDataException.class)
	public void Non_Leap_29Feb_Checkout() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2015.02.28 12:30", "2015.02.29 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}

	@Test(expected = DateFormatException.class)
	public void Wrong_Input_Format_Checkout() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2015.02.28 12:30", "2015.03.01 12:30min", ParkingLotType.ShortTerm);
		} catch (DateFormatException e) {
			throw e;
		}
	}
	
	@Test(expected = InvalidDataException.class)
	public void Checkout_Before_Checkin() throws InvalidDataException, DateFormatException {
		Calculator conta = new Calculator();
		try {
		conta.calculateParkingCost("2015.02.02 12:30", "2015.02.01 12:30", ParkingLotType.ShortTerm);
		} catch (InvalidDataException e) {
			throw e;
		}
	}
}
