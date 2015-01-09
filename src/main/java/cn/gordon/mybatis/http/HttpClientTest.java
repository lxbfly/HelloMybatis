/**
 * HttpClientTest.java   2015年1月9日 下午2:16:49 by gordon.li 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package cn.gordon.mybatis.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class HttpClientTest {

    public static void main(String[] args) {
        HttpClient hc = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://www.apache.org/");
        System.out.println("Http get request Url = " + httpGet.getURI());

        try {
            HttpResponse response = hc.execute(httpGet);
            HttpEntity entity = response.getEntity();

            System.out.println(response.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
                //                String contentStr = EntityUtils.toString(entity);
                //                System.out.println(contentStr);
                //                System.out.println("--------------------------------------");
                //TODO HttpEntity在使用EntityUtils读完后，再读就是为Null，为已经流已经被关闭
                //                String contentStr1 = EntityUtils.toString(entity);
                //                System.out.println(contentStr1);
            }
            entity.getContent();
            System.out.println("--------------------------------------");
            InputStream content = entity.getContent();
            Scanner inStream = new Scanner(content);
            while (inStream.hasNextLine()) {
                System.out.println(inStream.nextLine());
            }
            System.out.println("--------------------------------------");
            InputStream content1 = entity.getContent();
            Scanner inStream1 = new Scanner(content1);
            while (inStream1.hasNextLine()) {
                System.out.println(inStream1.nextLine());
            }
            System.out.println("没有读到值");
            System.out.println("--------------------------------------");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpGet.completed();
        }

    }
}
