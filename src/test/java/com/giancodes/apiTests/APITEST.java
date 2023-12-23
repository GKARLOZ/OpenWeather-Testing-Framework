package com.giancodes.apiTests;

import com.giancodes.api.DeleteDummyMethod;
import com.giancodes.api.GetDummyMethod;
import com.giancodes.api.GetWeatherMethod;
import com.giancodes.api.PostDummyMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITEST implements IAbstractTest {

    @Test()
    public void testGetWeatherwithZipCode(){
    GetWeatherMethod getWeather = new GetWeatherMethod("90242");
    getWeather.callAPIExpectSuccess();
    getWeather.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.TYPE.getKey());
    getWeather.validateResponseAgainstSchema("api/open_weather_api/_get/rs.schema");

    }

    @Test()
    public void testGetById(){
        GetDummyMethod getDummy = new GetDummyMethod("2");
        getDummy.callAPIExpectSuccess();
        getDummy.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.TYPE.getKey());
        getDummy.validateResponseAgainstSchema("api/dummy_api/_get/rs.schema");

    }
    @Test()
    public void testPostTitle(){
        PostDummyMethod postDummy = new PostDummyMethod();
        postDummy.setProperties("api/dummy_api/_post/post.properties");
        postDummy.callAPIExpectSuccess();
        postDummy.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.TYPE.getKey());

    }
    @Test()
    public void testDeleteTitle(){
        DeleteDummyMethod deleteDummy = new DeleteDummyMethod();
        deleteDummy.callAPIExpectSuccess();
        deleteDummy.validateResponse(JSONCompareMode.NON_EXTENSIBLE, JsonCompareKeywords.TYPE.getKey());

    }


}
