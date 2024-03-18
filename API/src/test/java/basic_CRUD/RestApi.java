package basic_CRUD;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class RestApi {

	int id;

	@Test(priority = 1)
	public void getRequest() {

		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2)).log()
				.all();

	}

	@Test(priority = 2)
	public void postRequest() {

		HashMap map = new HashMap();
		map.put("name", "John");
		map.put("job", "Tester");

		id = given().contentType("application/json").body(map).when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");
	}

	@Test(priority = 3, dependsOnMethods = { "postRequest" })
	public void putRequest() {

		HashMap map1 = new HashMap();
		map1.put("name", "Love");
		map1.put("job", "Automation Tester");

		given().contentType("application/json").body(map1).when().put("https://reqres.in/api/users/" + id).then()
				.statusCode(200).log().all();
	}

	@Test(priority = 4)
	public void deleteRequest() {

		given().when().delete("https://reqres.in/api/users/" + id).then().statusCode(204).log().all();
	}

	@Test(priority = 5)
	public void postRequestJason() {

		JSONObject map = new JSONObject();
		map.put("name", "baba");
		map.put("job", "Lifeinsurance");

		given().contentType("application/json").body(map.toString()).when().post("https://reqres.in/api/users").then()
				.statusCode(201).body("name", equalTo("baba")).body("job", equalTo("Lifeinsurance")).log().all();
	}

	@Test(priority = 6)
	public void postRequestPOJO() {

		POJO_post post = new POJO_post();

		post.setName("aayush");
		post.setJob("Lead");
		given().contentType("application/json").body(post).when().post("https://reqres.in/api/users").then()
				.statusCode(201).body("name", equalTo("aayush")).body("job", equalTo("Lead")).log().all();
	}

	@Test(priority = 7)
	public void getRequestField() {

		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
				.body("data[5].first_name", equalTo("Rachel")).log().all();

	}

}
