
package com.co.request.principal;

import com.co.request.get.GetRequest;
import com.co.request.post.PostRequest;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        try {
            runGet("");
        } catch (Exception e) {
            System.out.println("Se presento errores en el consumo");
            e.printStackTrace();
        }
    }

    public static void runPost(String url) throws IOException {
        PostRequest postRequest=new PostRequest();
        System.out.println(postRequest.doRequest(url));
    }

    public static void runGet(String url) throws IOException {
        GetRequest getRequest=new GetRequest();
        while(true){
            System.out.println(getRequest.doRequest(url));
            getRequest.closeClient();
        }
    }
}
