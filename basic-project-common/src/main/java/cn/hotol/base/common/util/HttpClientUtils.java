package cn.hotol.base.common.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * by yanwenjie on 2017/11/14
 */
public class HttpClientUtils {

    /**
     * http请求工具类，支持文件形式的参数
     *
     * @param url
     * @param params
     * @param encoding
     * @return
     */
    public static String HttpClientPost(String url ,Map<String ,Object> params ,String encoding) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpClient httpclient = new DefaultHttpClient();
        try{
            HttpPost post = new HttpPost(url);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            for (String key : params.keySet()){
                Object obj = params.get(key);
                if (obj instanceof File)
                    builder.addBinaryBody(key , (File) obj);
                else{
                    StringBody body = new StringBody(obj.toString() , Charset.forName(encoding));
                    builder.addPart(key ,body);
                }
            }

            post.setEntity(builder.build());

            HttpResponse response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entitys = response.getEntity();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(entitys.getContent()));
                String line = reader.readLine();
                return line;
            }else {
                HttpEntity r_entity = response.getEntity();
                String responseString = EntityUtils.toString(r_entity);
                return responseString;
            }
        }catch(Exception e){
            throw e;
        }finally {
            httpclient.getConnectionManager().shutdown();
        }

    }

}
