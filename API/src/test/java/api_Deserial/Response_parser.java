package api_Deserial;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class Response_parser {

	@Test(priority = 1)
	public void resposeParserJson() {

		Response res = given().contentType("application/json").when()
				.get("https://reqres.in/api/users?page=2");

		int index = -1;
		System.out.println(res.asString());
		JSONObject obj = new JSONObject(res.asString());

		for (int i = 0; i < obj.getJSONArray("data").length(); i++) {

			String name = obj.getJSONArray("data").getJSONObject(i)
					.get("first_name").toString();

			if (name.equals("Michael")) {

				index = i;
				break;

			}
		}

		String email = obj.getJSONArray("data").getJSONObject(index)
				.get("email").toString();

		System.out.println(email);

	}

	@Test(priority = 2)
	public void resposeParserPojo() throws Exception, Exception  {

		ObjectMapper mapper = new ObjectMapper();
		Response res = given().contentType("application/json").when()
				.get("https://reqres.in/api/users?page=2");

		String testJson = res.asString();
		POJO_root readValue = mapper.readValue(testJson, POJO_root.class);
		System.out.println("readValue = " + readValue);
		// String g = readValue.data.get(0).first_name;

		int index = -1;
		for (int i = 0; i < readValue.data.size(); i++) {

			if (readValue.data.get(i).getFirst_name().equals("Michael")) {

				index = i;
				break;

			}

		}

		System.out.println(readValue.data.get(index).getEmail());

	}

}
