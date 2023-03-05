package basics;

public class JsonBody {
	
	
	public static String createUserBody()
	{
		String body = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"testtwo\",\r\n"
				+ "  \"firstName\": \"two\",\r\n"
				+ "  \"lastName\": \"three\",\r\n"
				+ "  \"email\": \"onetwothree@a.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"8795643211\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
		
		return body;
	}

}
