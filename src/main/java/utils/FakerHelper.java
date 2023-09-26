package utils;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.OptionalInt;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class FakerHelper {

		static Faker fakers = new Faker();

		static String dummy = "Test";

		public static String getEmail() {
			return fakers.internet().emailAddress();
		}

		public static String getFirstName() {
			return fakers.name().firstName().concat(dummy);
		}

		public static String getLastName() {
			return fakers.name().lastName().concat(dummy);
		}

		public static String getUsermobileNumber() {
			return fakers.phoneNumber().phoneNumber();
		}

		public static String getUserId() {
			return fakers.address().countryCode().concat(dummy);
		}

		public static String getAddressLine() {
			return fakers.address().streetAddress();
		}
		
		public static String getAddressLine2() {
			return fakers.address().streetName();
		}
		public static String getCity() {
			return fakers.address().city().concat(dummy);

		}

		public static String getState() {
			return fakers.address().state().concat(dummy);
		}

		public static String getZip() {
			return fakers.address().zipCode();
		}

		public static String getCountry() {
			return fakers.address().country().concat(dummy);
		}

		public static String getRandomMonth() {
			Random random = new Random();
			OptionalInt randomNumberMonth = random.ints(1, 12).findFirst();
			return Month.of(randomNumberMonth.getAsInt()).getDisplayName(TextStyle.FULL, Locale.US);
		}

		public static Boolean getRandomBoolean() {
			return new Random().nextBoolean();
		}

		public static String getRandomLongDescription() {
			return RandomStringUtils.random(996, true, true).concat(dummy);
		}

		public static String getRandomShortDescription() {
			return RandomStringUtils.random(50, true, true);
		}

		public static String getRandomNumber() {
			return RandomStringUtils.random(10, true, true);
		}
		public static int getRandom5DigitNumber() {
			return Integer.parseInt(RandomStringUtils.random(5, false, true));
		}
		
		public static int getRandomNumberBasedOnSize(int number) {
			return Integer.parseInt(RandomStringUtils.random(number, false, true));
		}
		
		public static String getDescription() {

			String[] list = { "Lien Notice", "Officials Other Fees", "Regular Marr Licenses", "Confidential Marr Licenses",
					"Transfer Taxes" };
			Random r = new Random();
			String Description = list[r.nextInt(list.length)];

			return Description;
		}

		public static String getCityType() {

			String[] list = { "Incorporated", "Conveyance", "UnIncorporated" };
			Random r = new Random();
			String CityType = list[r.nextInt(list.length)];

			return CityType;
		}

		public static String getCityCode() {

			String[] list = { "AL", "AK", "AZ", "AR", "CO", "CA", "CT", "FL", "HI", "IL", "IA", "KS", "KY", "LA", "MD",
					"MA", "MI", "MS", "MT", "UT" };
			Random r = new Random();
			String code = list[r.nextInt(list.length)];

			return code;
		}

		public static String getRandomFundType() {
			List<String> listFundTypes = Arrays.asList("CountyFund", "GeneralFund", "StateFund", "ThirdPartFund");
			return listFundTypes.get(new Random().nextInt(listFundTypes.size()));
		}

		public static String getDirection() {
			List<String> listDirection = Arrays.asList("N", "W", "S", "E", "NE", "SW", "NW", "SE");
			return listDirection.get(new Random().nextInt(listDirection.size()));
		}
		
	  
		public   static String UUID() {
			//generates random UUID.
			UUID uuid=UUID.randomUUID();
			String uuidAsString = uuid.toString();  
			return  uuidAsString ;
		}
		
		public static int getRandomInteger(int min, int max) {
		    Random random = new Random();
		    return random.nextInt((max - min) + 1) + min;
		}
}
