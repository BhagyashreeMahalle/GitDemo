package Files;

import io.restassured.path.json.JsonPath;

public class Reusables {

		public static JsonPath rawToJason(String response)
		{
			JsonPath js1 = new JsonPath(response);
			return js1;
		}
}
