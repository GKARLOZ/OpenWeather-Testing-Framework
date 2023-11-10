package com.giancodes.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url ="${url}/posts",methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/dummy_api/_post/rq.json")
@ResponseTemplatePath(path = "api/dummy_api/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostDummyMethod extends AbstractApiMethodV2 {
    public PostDummyMethod(){
        replaceUrlPlaceholder("url", Configuration.getRequired("dummy_api_url"));

    }
}
