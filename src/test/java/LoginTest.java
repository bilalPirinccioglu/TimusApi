import Utilities.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    void LoginSuccesfull() {


        Map<String , Object> map= new HashMap<String,Object>();
        map.put("action",null);
        map.put("correlation_id",null);
        map.put("email","nepex86621@alibrs.com");
        map.put("password","Timus2020**");
        map.put("paltform","manager");
        map.put("token",null);
        map.put("version","1.12.0");

        Response response = given()
                .contentType("application/json")
                .body(map)
                .post(ConfigReader.getProperty("End-point"));

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    void LoginFail(){
        Map<String , Object> map= new HashMap<String,Object>();
        map.put("action",null);
        map.put("correlation_id",null);
        map.put("email","test@alibrs.com");
        map.put("password","22**");
        map.put("paltform","manager");
        map.put("token",null);
        map.put("version","1.12.0");

        Response response = given()
                .contentType("application/json")
                .body(map)
                .post(ConfigReader.getProperty("End-point"));

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 400);
    }
}
