package com.giancodes.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${url}/data/2.5/weather?zip=${zip_code},us&appid=${token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path="api/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherMethod extends AbstractApiMethodV2 {

    public GetWeatherMethod(){
        replaceUrlPlaceholder("url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("zip_code", "90001");
        replaceUrlPlaceholder("token", Configuration.getRequired("api_token"));

    }
    public GetWeatherMethod(String zipCode){
        replaceUrlPlaceholder("url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("zip_code", zipCode);
        replaceUrlPlaceholder("token", Configuration.getRequired("api_token"));

    }
}
