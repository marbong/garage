package kt.mock;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class MockApi {
	
	@Value("${mock.api.url}")
	private String mockApiUrl;
	
	@Value("${mock.api.path}")
	private String mockApiPath;
	
	public String getApiCall(String msg) {
		
		HttpURLConnection con = null;
		BufferedReader br = null;
		StringBuffer response = new StringBuffer();
		
		try {
			
			URL url = new URL(mockApiUrl + mockApiPath);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "text/plain");
			con.setRequestProperty("charset", "utf-8");
			con.setDoOutput(true);
	 
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(msg);
			
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
			if(null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return response.toString();
	}
}
