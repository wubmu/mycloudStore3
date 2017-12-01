package com.wyb.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by 吴亚斌 on 2017/11/27.
 */
public class officeTran {
    public static void Tran() throws IOException {
        String apiKey = "2NWjPvn0LaXgVci4OsLGaoFjZJCtKKcF";
        File file = new File("C:\\Users\\吴亚斌\\Desktop\\云盘项目\\云盘数据库说明.xlsx");
//http://view.webofficeapi.com/docs/M69Q8Z4N
//        http://view.webofficeapi.com/docs/M69Q8Z4N/qrcode
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://view.webofficeapi.com/upload");

            StringBody apiKeyPart = new StringBody(apiKey, ContentType.TEXT_PLAIN);
            FileBody filePart = new FileBody(file);

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("api_key", apiKeyPart)
                    .addPart("file", filePart)
                    .build();

            httppost.setEntity(reqEntity);

            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                System.out.println(EntityUtils.toString(resEntity));
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
    }

}
