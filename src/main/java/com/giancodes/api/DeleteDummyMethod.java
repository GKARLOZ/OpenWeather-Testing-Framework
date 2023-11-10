package com.giancodes.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${url}/posts/${id}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path="api/dummy_api/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteDummyMethod extends AbstractApiMethodV2 {

    public DeleteDummyMethod(){

            replaceUrlPlaceholder("url", Configuration.getRequired("dummy_api_url"));
            replaceUrlPlaceholder("id", "1");
        }
    public DeleteDummyMethod(String id){
            replaceUrlPlaceholder("url", Configuration.getRequired("dummy_api_url"));
            replaceUrlPlaceholder("id", id);

        }


   }

