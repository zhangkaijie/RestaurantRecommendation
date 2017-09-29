package com.laioffer.laiofferproject;


import android.util.Log;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class YelpApi {
    private static final String API_HOST = "api.yelp.com";
    private static final String SEARCH_PATH = "/v2/search";

    private static final String CONSUMER_KEY = "KNUcaFWU30YZUArC-Meowg";
    private static final String CONSUMER_SECRET = "HU2VUT6GYv4p-RTcA4IwY50bKV0";
    private static final String TOKEN = "qep8z-vtLObnIF3iM-UVFtkkqL7CbY8Y";
    private static final String TOKEN_SECRET = "dtgfREYRVvDP0d54wx_r-n6DbrM";

    private OAuthService service;
    private Token accessToken;

    /**
     * Setup the Yelp API OAuth credentials.
     */
    public YelpApi() {
        this.service = new
                ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET).build();
        this.accessToken = new Token(TOKEN, TOKEN_SECRET);
    }

    /**
     * Fire a search request to Yelp API.
     */
    public String searchForBusinessesByLocation(String term, String location, int searchLimit) {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(searchLimit));
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        Log.i("message", response.getBody());
        return response.getBody();
    }
}

