package com.base.drest.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * HttpTest
 * @author zhouyw
 * @date 2018.04.24
 */
public class HttpTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 动态修改日志等级
     * @throws URISyntaxException
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void testDynamicLog() throws URISyntaxException, IOException, URISyntaxException {
        String url = "http://127.0.0.1:8770/drest-service";
        String resource = "/actuator/loggers/com.base.drest";
        String msg = "{\"effectiveLevel\":\"INFO\"}";
        URI uri = new URI(url + resource);


        SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
        ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.POST);
        HttpHeaders headers = chr.getHeaders();
        headers.add("Content-type", "application/json;charset=UTF-8");
        chr.getBody().write(msg.getBytes("UTF-8"));
        ClientHttpResponse res = chr.execute();

        HttpStatus statusCode = res.getStatusCode();
        logger.info("resp-->statusCode={}", statusCode);//服务器返回的是一个HTTP/204响应,当前页面不会有任何变化,就好像根本没有进行导航操作一样.页面的URL地址也保持不变.  修改成功

        InputStream is = res.getBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = "";
        while ((str = br.readLine()) != null) {
            logger.info("-->str={}", str);
        }



    }

}
