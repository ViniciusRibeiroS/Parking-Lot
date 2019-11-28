package imd0412.parkinglot.calculator;

import org.junit.Assert;
import org.junit.Test;

import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

public class CalculatorTest
{
	//Day, month and year min/max Tests in checkin/checkout	
	@Test
	public void Lower_Limit_Year_Checkin() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("1970.01.01 12:30", "1970.01.01 12:30", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Lower_Limit_Year_Checkout() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("1970.01.01 12:30", "1970.01.01 12:30", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Between_Limit_Year_Checkin() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("2017.01.01 12:30", "2017.01.01 12:30", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Between_Limit_Year_Checkout() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("2017.01.01 12:30", "2017.01.01 12:30", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Higher_Limit_Year_Checkout() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("2018.12.31 23:59", "2019.01.01 00:00", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Higher_Limit_Year_Checkin() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("2018.01.01 12:30", "2018.01.01 12:30", ParkingLotType.ShortTerm), 0);
	}
	
	//Price of all Short Term variation
	//A hour (Código 1 da Tabela de Decisão)
	@Test
	public void Lower_Limit_a_Hour_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
        Assert.assertEquals(8.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 12:30", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Between_a_Hour_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
        Assert.assertEquals(8.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 12:45", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Higher_Limit_a_hour_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(8.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 12:30", ParkingLotType.ShortTerm), 0);		
	}
	
	//Between More than a Hour and less than a day (Código 2 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Than_a_hour_Less_Than_a_Day_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
        Assert.assertEquals(10.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 13:31", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Between_More_Than_a_Hour_Less_Than_a_Day_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(12.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 14:30", ParkingLotType.ShortTerm), 0);
	}
	@Test
	public void Higher_Limit_More_Than_a_Hour_Less_Than_a_Day_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(56.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.09 12:29", ParkingLotType.ShortTerm), 0);		
	}
	
	//Between a Day and less than a week (Código 3 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Than_a_Day_Less_Than_a_Week_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(106.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.09 12:30", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Between_More_Than_a_Day_Less_Than_a_Week_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(204.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.10 12:30", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Between_More_Than_a_Day_Less_Than_a_Week_ShortTerm_extra_Minute() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(206.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.10 12:31", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Higher_Limit_More_Than_a_Day_Less_Than_a_Week_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(694.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.15 12:30", ParkingLotType.ShortTerm), 0);		
	}
	
	//Plus than a Week (Código 4 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Than_a_Week_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(696.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.15 12:31", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Between_More_Than_a_Week_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(772.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.16 12:30", ParkingLotType.ShortTerm), 0);		
	}
	@Test
	public void Limit_More_Than_a_Week_plus_otherday_ShortTerm() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(774.0, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.16 12:31", ParkingLotType.ShortTerm), 0);		
	}
	
	
	//Price of all Long Term variation
	//Less than a day (Código 5 da Tabela de Decisão)
	@Test
	public void Lower_Limit_Less_Than_a_Day_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(70, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 12:30", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Between_Less_Than_a_Day_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(70, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 15:30", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Higher_Limit_Less_Than_a_Day_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(70, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.09 12:30", ParkingLotType.LongTerm), 0);	
	}
	
	//A day and less than a week (Código 6 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Than_Day_Less_Then_A_Week_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(120, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.09 12:31", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Between_More_Than_Day_Less_Then_A_Week_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(170, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.10 12:30", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Between_More_Than_Day_Less_Then_A_Week_with_extra_minute_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(220, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.10 12:31", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Higher_Limit_More_Than_Day_Less_Then_A_Week_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(370, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.14 12:30", ParkingLotType.LongTerm), 0);	
	}
	
	//A week less than a month (Código 7 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Than_A_Week__Less_Than_a_Month_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(420, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.14 12:31", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Between_More_Than_A_Week__Less_Than_a_Month_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(450, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.16 12:30", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Between_More_Than_A_Week__Less_Than_a_Month_Long_Term_with_Extra_minute() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(480, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.16 12:31", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Higher_Limit_More_Than_A_Week__Less_Than_a_Month_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1110, conta.calculateParkingCost("2016.04.08 12:30", "2016.05.08 12:29", ParkingLotType.LongTerm), 0);	
	}
	
	//A month and beyond (Código 8 da Tabela de Decisão)
	@Test
	public void Lower_Limit_A_Month_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1610, conta.calculateParkingCost("2016.04.08 12:30", "2016.05.08 12:30", ParkingLotType.LongTerm), 0);	
	}
	@Test
	public void Limit_A_Month_And_A_Day_Long_Term() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1640, conta.calculateParkingCost("2016.04.08 12:30", "2016.05.08 12:31", ParkingLotType.LongTerm), 0);	
	}
	
	//Price of all Vip variation
	//Less than a Week (Código 9 da Tabela de Decisão)
	@Test
	public void Lower_Limit_Less_Then_A_Week_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(500, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.08 12:30", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Between_Less_Then_A_Week_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(500, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.10 12:30", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Higher_Limit_Less_Then_A_Week_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(500, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.15 12:30", ParkingLotType.VIP), 0);	
	}
	
	//A week and less than 2 Weeks (Código 10 da Tabela de Decisão)
	@Test
	public void Lower_Limit_More_Then_A_Week_Less_Than_Two_Weeks_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(600, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.15 12:31", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Between_More_Then_A_Week_Less_Than_Two_Weeks_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1000, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.20 12:30", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Between_More_Then_A_Week_Less_Than_Two_Weeks_Extra_Minute_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1100, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.20 12:31", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Higher_Limit_More_Then_A_Week_Less_Than_Two_Weeks_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1200, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.22 12:30", ParkingLotType.VIP), 0);	
	}
	
	//Higher than 2 Weeks and beyond (Código 11 da Tabela de Decisão)
	@Test
	public void LowerLimit_More_Then_Two_Weeks_Vip() throws InvalidDataException, DateFormatException
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1280, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.22 12:31", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Limit_More_Then_Two_Weeks_And_A_Day_Vip() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1360, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.24 12:30", ParkingLotType.VIP), 0);	
	}
	@Test
	public void Limit_More_Then_Two_Weeks_And_A_Day_Vip_With_Extra_Minute() throws InvalidDataException, DateFormatException 
	{
		Calculator conta = new Calculator();
		Assert.assertEquals(1440, conta.calculateParkingCost("2016.04.08 12:30", "2016.04.24 12:31", ParkingLotType.VIP), 0);	
	}
}
