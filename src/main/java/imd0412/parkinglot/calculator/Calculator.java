package imd0412.parkinglot.calculator;

import java.time.Duration;
import java.time.LocalDateTime;
import javax.activity.InvalidActivityException;
import imd0412.parkinglot.Constants;
import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;
import imd0412.parkinglot.exception.InvalidDataType;

public class Calculator {
	/**
	 * Calculates the staying cost in the parking lot.
	 * 
	 * @param checkin
	 *            String representing check-in date. String follows the format
	 *            "yyyy.MM.dd HH:mm".
	 * @param checkout
	 *            String representing check-out date. String follows the format
	 *            "yyyy.MM.dd HH:mm".
	 * @param type
	 * @return
	 * @throws DateFormatException 
	 * @throws InvalidActivityException 
	 */
	
	//Validate the checkin
	public LocalDateTime checkin_Validation(String checkin) throws InvalidDataException, DateFormatException {
    	
		//Verify the day
		int day_checkin =  Integer.parseInt(checkin.substring(8, 10));
		if (day_checkin < 1 || day_checkin > 31) {
			throw new InvalidDataException("Dia fora do limite: 1 - 31", InvalidDataType.InvalidDay);
		}
		
		//Verify the month
		int month_checkin =  Integer.parseInt(checkin.substring(5, 7));
		if (month_checkin < 1 || month_checkin > 12) {
			throw new InvalidDataException("Mês fora do limite: 1 - 12", InvalidDataType.InvalidMonth);
		}
		
		//Verify the year
		int year_checkin = Integer.parseInt(checkin.substring(0,4));
    	if (year_checkin < 1970 || year_checkin > 2018) {
			throw new InvalidDataException("Ano fora do limite: 1970 - 2018", InvalidDataType.InvalidYear);
		}
		
    	//Verify a leap date on a non leap year
    	if(year_checkin % 4 > 0 && (day_checkin == 29 && month_checkin == 2)){
			throw new InvalidDataException("Data não Existente", InvalidDataType.NonexistentDate);
    	}
    	
    	//Verify a month without 31 days with 31 days
    	if(day_checkin == 31 && (month_checkin == 2 || month_checkin == 4 || month_checkin == 6 || month_checkin == 9
    			|| month_checkin == 11)) {
			throw new InvalidDataException("Data não Existente", InvalidDataType.NonexistentDate);
    	}
    	
    	//Verify checkin format
    	try {
    		LocalDateTime.parse(checkin, Constants.DATE_FORMATTER);
    	} catch (Exception e) {
			throw new DateFormatException("Formatação fora dos padrões: yyyy.MM.dd HH:mm");
    	}
		
    	//If everything is fine return checkin as LocalDateTime
    	LocalDateTime checkinTime = LocalDateTime.parse(checkin, Constants.DATE_FORMATTER);
		return checkinTime;		
	}
	
	//Validate the checkout
	public LocalDateTime checkout_Validation(String checkout) throws InvalidDataException, DateFormatException {
		
		//Verify the day
		int day_checkout =  Integer.parseInt(checkout.substring(8, 10));
		if (day_checkout < 1 || day_checkout > 31) {
				throw new InvalidDataException("Dia fora do limite: 1 - 31", InvalidDataType.InvalidDay);
		}
				
		//Verify the month
		int month_checkout =  Integer.parseInt(checkout.substring(5, 7));
		if (month_checkout < 1 || month_checkout > 12) {
				throw new InvalidDataException("Mês fora do limite: 1 - 12", InvalidDataType.InvalidMonth);
		}
				
		//Verify the year
		int year_checkout = Integer.parseInt(checkout.substring(0,4));
		if (year_checkout < 1970 || year_checkout > 2019) {
				throw new InvalidDataException("Ano fora do limite: 1970 - 2019", InvalidDataType.InvalidYear);
		}
				
		//Verify a leap date on a non leap year
		if(year_checkout % 4 > 0 && (day_checkout == 29 && month_checkout == 2)){
			throw new InvalidDataException("Data não Existente", InvalidDataType.NonexistentDate);
		}

		
		//Verify a month without 31 days with 31 days
		if(day_checkout == 31 && (month_checkout == 2 || month_checkout == 4 || month_checkout == 6 || month_checkout == 9 || month_checkout == 11)) {
			throw new InvalidDataException("Data não Existente", InvalidDataType.NonexistentDate);
		}
		    	
	    //Verify checkout format
		try {
		    LocalDateTime.parse(checkout, Constants.DATE_FORMATTER);
		} catch (Exception e) {
			throw new DateFormatException("Formatação fora dos padrões: yyyy.MM.dd HH:mm");
		}
		
		//If everything is fine return checkout as LocalDateTIme
		LocalDateTime checkoutTime = LocalDateTime.parse(checkout, Constants.DATE_FORMATTER);
		return checkoutTime;	
	}
	
	//Verify duration time
	public Duration parkedtime_Valdation(LocalDateTime checkinTime, LocalDateTime checkoutTime) throws InvalidDataException {
		Duration duration = Duration.between(checkinTime, checkoutTime);
		
		//If duration is lower than 0 throw exception
		if(duration.toMinutes() < 0) {
	       throw new InvalidDataException("Checkout Registrado com Data anterior ao Chekin", null);
		}
		
		//If duration is equal or higher than 0 return duration
		return duration;
	}
	
	//Calculate the price of ShortTerm ParkedTime
    public int price_ShortTerm(Duration parkedTime) {
    	int FirstHour_ShortTerm = 8;
    	int ExtraHour_ShortTerm = 2;
    	int TaxDay_ShortTerm = 	50;
    	int More7DayTax_ShortTerm = 30;
    	int Ticket_Price = 0;
    	
    	//Pay only the Entrance 
    	if(parkedTime.toMinutes() <= 60) {
    		 Ticket_Price = FirstHour_ShortTerm;
    	}
    	
    	//Pay the Entrance and extra hours
    	if(parkedTime.toMinutes() > 60 && parkedTime.toMinutes() < 1440) {
    		 Ticket_Price = FirstHour_ShortTerm;
    		 Ticket_Price += ExtraHour_ShortTerm * parkedTime.toHours();
    		 
    		 if(parkedTime.toMinutes() % parkedTime.toHours() > 0) {
    			 Ticket_Price += ExtraHour_ShortTerm;
    		 }
    	}
    	
    	//More than a day and less than a week
    	if(parkedTime.toMinutes() >= 1440 && parkedTime.toMinutes() <= 10080) {
    		Ticket_Price = FirstHour_ShortTerm;
    		Ticket_Price += ExtraHour_ShortTerm * parkedTime.toHours();
    		Ticket_Price += TaxDay_ShortTerm * parkedTime.toDays();
    		
    		if(parkedTime.toMinutes() % parkedTime.toHours() > 0) {
   			 Ticket_Price += ExtraHour_ShortTerm;
   		 }
    	}
    	
    	//More then a week
    	if(parkedTime.toMinutes() > 10080) {
    		Ticket_Price = FirstHour_ShortTerm;
    		Ticket_Price += ExtraHour_ShortTerm * parkedTime.toHours();
    		Ticket_Price += TaxDay_ShortTerm * 7;
    		Ticket_Price += More7DayTax_ShortTerm * (parkedTime.toDays() - 7);
    		
    		if(parkedTime.toMinutes() % parkedTime.toHours() > 0) {
      			 Ticket_Price += ExtraHour_ShortTerm;
      		 }
    	}
    	
    	//return the ticket price
    	return Ticket_Price;
    }
	
    //Calculate the price of LongTerm ParkedTime
    public int price_LongTerm(Duration parkedTime) {
    		int DayPrice_LongTerm = 70;
    		int DayTax_LongTerm = 50;
    		int More7DayTax_LongTerm = 30;
    		int MonthTax_LongTerm = 500;
    		int ticket_Price = 0;
    		
            //Less than a day
    		if(parkedTime.toMinutes() <= 1440) {
    	       ticket_Price = DayPrice_LongTerm;
    		}
    		
    		//A day and less than a week
    		if(parkedTime.toMinutes() > 1440 && parkedTime.toMinutes() < 10080) {
    			ticket_Price = DayPrice_LongTerm;
    			ticket_Price += DayTax_LongTerm * parkedTime.toDays();
    			
    			if(parkedTime.toMinutes() % parkedTime.toDays() > 0) {
    				ticket_Price += DayTax_LongTerm;
    			}
    		}
    		
    		//A week and less than a month
    		if(parkedTime.toMinutes() >= 10080 && parkedTime.toDays() < 30) {
    			ticket_Price = DayPrice_LongTerm;
    			ticket_Price += DayTax_LongTerm * 7;
    			ticket_Price += More7DayTax_LongTerm * (parkedTime.toDays() - 7);
                
    			if(parkedTime.toMinutes() % parkedTime.toDays() > 0) {
    				ticket_Price += More7DayTax_LongTerm;
    			}
    		}
    		
    		//More than a month
    		if(parkedTime.toDays() >= 30) {
    			ticket_Price = DayPrice_LongTerm;
    			ticket_Price += DayTax_LongTerm * 7;
    			ticket_Price += More7DayTax_LongTerm * (parkedTime.toDays() - 7);
    			
    			if(parkedTime.toMinutes() % parkedTime.toDays() > 0) {
    				ticket_Price += More7DayTax_LongTerm;
    			}
    			
    			ticket_Price += (parkedTime.toDays() / 30) * MonthTax_LongTerm;
    		}
    	
    		//return Ticket Price
    		return ticket_Price;
    }
	
    //Calculate the price of VIP ParkedTime
    public int price_Vip(Duration parkedTime) {
		int WeekPrice_VIP = 500;
		int DayTaxFirstWeek_VIP = 100;
		int More14DayTax = 80;
		int Ticket_Price = 0;

		//Less than a week
		if (parkedTime.toMinutes() < 10080) {
			Ticket_Price = WeekPrice_VIP;
		}
		
		//A week and less than 2 weeks
		if (parkedTime.toMinutes() >= 10080 && parkedTime.toMinutes() <= 20160) {
			Ticket_Price = WeekPrice_VIP;
			Ticket_Price += DayTaxFirstWeek_VIP * (parkedTime.toDays() - 7);
			
			if(parkedTime.toMinutes() % parkedTime.toDays() > 0) {
    				Ticket_Price += DayTaxFirstWeek_VIP;
			}		
		}
		
		//2 week plus
		if (parkedTime.toMinutes() > 20160) {
			Ticket_Price = WeekPrice_VIP;
			Ticket_Price += DayTaxFirstWeek_VIP * 7;
			Ticket_Price += More14DayTax *(parkedTime.toDays() - 14);
			
			if(parkedTime.toMinutes() % parkedTime.toDays() > 0) {
				Ticket_Price += More14DayTax;
			}	
		}
		
		//return Ticket Price
		return Ticket_Price;
	}
    	
    //Calculate the ticket price based on the ParkingLotType and verify the checkin and the checkout 
    public Float calculateParkingCost(String checkin, String checkout, ParkingLotType type) throws InvalidDataException, DateFormatException {		
		
		//Start Ticket Park as 0
    	float Ticket_Park = 0;
		
		//Check the input of checkin/checkout, will throw an exception if something is wrong;
		LocalDateTime checkinTime = checkin_Validation(checkin);
    	LocalDateTime checkoutTime = checkout_Validation(checkout);
    	
    	//Check the duration(	checkout - checkin	)
    	parkedtime_Valdation(checkinTime, checkoutTime);
    	
    	Duration parkedTime = Duration.between(checkinTime, checkoutTime);
        
    	//If the ParkingLotType is ShortTerm call the price_ShortTerm function
    	if(type == ParkingLotType.ShortTerm) {
    		Ticket_Park = price_ShortTerm(parkedTime);
    	}
    	
    	//If the ParkingLotType is LongTerm call the price_LongTerm function
    	if(type == ParkingLotType.LongTerm) {
    		Ticket_Park = price_LongTerm(parkedTime);
    	}
    	 	
    	//If the ParkingLotType is VIP call the price_Vip function
    	if(type == ParkingLotType.VIP) {
    		Ticket_Park = price_Vip(parkedTime);
    	}
    			
    	//Return Ticket Park
		return Ticket_Park;
	}

}
