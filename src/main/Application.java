/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

		URL url = new URL("https://api.sunrise-sunset.org/json?lat=45.267136&lng=19.833549"); // lat & lng = Geografska
																								// sirina i duzina

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		String content = "";
		while ((inputLine = in.readLine()) != null) {
			content += inputLine;
		}
		System.out.println(content);
		in.close();
	}

}
