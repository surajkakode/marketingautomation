package screener;


import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class PostScreenerData {
    public static final Logger log = Logger.getLogger(PostScreenerData.class.getName());


    public void postData(Screener data) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(System.getProperty("userName"));
        authScheme.setPassword(System.getProperty("passWord"));
        RestAssured.authentication = authScheme;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        /*Gson gson = new Gson();
        String json =  gson.toJson(data);*/

        request.body(data);
        Response response = request.post(System.getProperty("URI"));
    }
}