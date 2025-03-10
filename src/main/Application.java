/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
																								// sirina i duzina

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		String content = "";
		while ((inputLine = reader.readLine()) != null) {
			content += inputLine;
		}
		reader.close();
		
		JsonElement element = gson.fromJson (content, JsonElement.class);
		JsonObject jsonObj = element.getAsJsonObject();
		
		System.out.println(jsonObj);
		System.out.println(jsonObj.get("results"));
	}

}
