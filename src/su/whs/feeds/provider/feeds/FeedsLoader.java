package su.whs.feeds.provider.feeds;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

public class FeedsLoader {
	public static JSONArray loadJson(String url) {
		HttpClient http = new DefaultHttpClient();
		HttpResponse response;
		try {
			response = http.execute(new HttpGet(url));
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode()==HttpStatus.SC_OK) {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				response.getEntity().writeTo(bos);
				bos.close();
				String json = bos.toString();
				JSONArray ja = new JSONArray(json);
				return ja;
			}
		} catch (ClientProtocolException e) {
			
		} catch (IOException e) {
			
		} catch (JSONException e) {
		
		}
		return new JSONArray();
	}
}
