/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Zavuisna biblioteka: gson-2.12.1.jar
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 */
public class Application {

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		
		URL url = new URL("https://api.sunrise-sunset.org/json?lat=45.267136&lng=19.833549"); // lat & lng = Geografska
																								// sirina i duzina Novog Sada
		
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // TODO dodati try-catch u slucaju da je odgovor drugaciji od 200
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/json");

		// Isti princip kao citanje iz fajla u javi, gradimo string
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		String content = "";
		while ((inputLine = reader.readLine()) != null) {
			content += inputLine;
		}
		reader.close();
		
		// Od dobijenog stringa pravimo JSON objekat
		JsonElement element = gson.fromJson (content, JsonElement.class);
		JsonObject jsonObj = element.getAsJsonObject();
		
		System.out.println(jsonObj); 
		// Primer JSON odgovora dobijenim od API poziva:
		/* {
			  "results": {
			    "sunrise": "5:00:25 AM",
			    "sunset": "4:41:18 PM",
			    "solar_noon": "10:50:52 AM",
			    "day_length": "11:40:53",
			    "civil_twilight_begin": "4:32:33 AM",
			    "civil_twilight_end": "5:09:10 PM",
			    "nautical_twilight_begin": "3:58:22 AM",
			    "nautical_twilight_end": "5:43:21 PM",
			    "astronomical_twilight_begin": "3:23:45 AM",
			    "astronomical_twilight_end": "6:17:59 PM"
			  },
			  "status": "OK",
			  "tz
		*/
		System.out.println(jsonObj.getAsJsonObject("results").get("sunrise")); //Ugnezdjeni Kljucevi 
	}

}
