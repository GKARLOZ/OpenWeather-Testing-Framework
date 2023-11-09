package com.giancodes;

import com.giancodes.api.GetWeatherMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APITEST implements IAbstractTest {

    @Test()
    public void testGetWeatherwithZipCode(){
    GetWeatherMethod getWeather = new GetWeatherMethod("90242");
    getWeather.callAPIExpectSuccess();
    getWeather.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.TYPE.getKey());
    getWeather.validateResponseAgainstSchema("api/_get/rs.schema");

}

}
