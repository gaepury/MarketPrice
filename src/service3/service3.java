package service3;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/dir")
public class service3 {
	private static final String DEFAULT_URL = "https://www.google.co.kr/maps/dir/";

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/{lon}-{lat}/{name}")
	public String loadSearch(@PathParam("lon") double lon, @PathParam("lat") double lat,
			@PathParam("name") String name) {

		String dirurl;
		String jsonResult = "{ \"result\" : ";
		URL url;
		try {
			url = new URL(DEFAULT_URL + lat + "," + lon + "/" + name);

			dirurl = url.toString();

			jsonResult += "\"" + dirurl + "\"}";

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			jsonResult += "\"fail\"}";
		}

		return jsonResult;

	}

}
