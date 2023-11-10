package com.giancodes.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${url}/posts/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path="api/dummy_api/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetDummyMethod extends AbstractApiMethodV2 {

        public GetDummyMethod(){
            replaceUrlPlaceholder("url", Configuration.getRequired("dummy_api_url"));
            replaceUrlPlaceholder("id", "1");

        }
    public GetDummyMethod(String id){
        replaceUrlPlaceholder("url", Configuration.getRequired("dummy_api_url"));
        replaceUrlPlaceholder("id", id);

    }


}
