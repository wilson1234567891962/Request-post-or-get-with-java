/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.request.get;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {

    CloseableHttpClient httpClient;

    public String doRequest(String url) throws IOException {
        httpClient= HttpClients.createDefault();
        StringBuilder dto=new StringBuilder();
        HttpGet request = new HttpGet(url);

        // add request headers
        request.addHeader(HttpHeaders.USER_AGENT, "UTF-8");

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                dto.append(result);
            }

        }
        return dto.toString();
    }

    public void closeClient() throws IOException {
        this.httpClient.close();
    }
}
