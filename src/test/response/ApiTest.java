import com.google.gson.Gson;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class ApiTest extends TestBase {
    TestBase testBase;
    String serviceUrl;
    ResponseData responseData;
    HttpResponse<String> response;
    ValidateJsonData validateJsonData;

    @BeforeMethod
    public void setUp() throws ClientProtocolException, IOException {
        testBase = new TestBase();
        serviceUrl = prop.getProperty("baseURL");
        CommonUtils.setValidateJsonData("validate");
    }

    @Test(priority = 1)
    public void verifyStatusCode() throws UnirestException {
        response = Unirest.get(serviceUrl)
                .header("Content-Type", "application/json").asString();
        System.out.println(response.getBody());
        responseData = (new Gson().fromJson(response.getBody(), ResponseData.class));
        Assert.assertEquals(response.getStatus(), testBase.RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 2)
    public void validateResponseHeader() {
        Headers headers = response.getHeaders();
        String contentType = headers.getFirst("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=UTF-8");

    }

    @Test(priority = 3)
    public void validateResponseData() {

        Assert.assertEquals(CommonUtils.getValidateJsonData().getEmployeeData()[0].getCompany(), responseData.getEmployeeData()[0].getCompany());
    }


    @Test(priority = 4)
    public void validateResponseDataWithWrongValue() {
        Assert.assertEquals(CommonUtils.getValidateJsonData().getEmployeeData()[1].getCompany(), responseData.getEmployeeData()[0].getCompany());
    }


}
