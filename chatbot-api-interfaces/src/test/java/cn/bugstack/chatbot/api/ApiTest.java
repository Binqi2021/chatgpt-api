package cn.bugstack.chatbot.api;



import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885124815212/topics?scope=by_owner&count=20");

        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415428418581518%22%2C%22first_id%22%3A%2218a8e30fbad520-0f1535de6db44a-26031f51-3686400-18a8e30fbae6d1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.yuque.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhOGUzMGZiYWQ1MjAtMGYxNTM1ZGU2ZGI0NGEtMjYwMzFmNTEtMzY4NjQwMC0xOGE4ZTMwZmJhZTZkMSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNTQyODQxODU4MTUxOCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415428418581518%22%7D%2C%22%24device_id%22%3A%2218a8e30fbad520-0f1535de6db44a-26031f51-3686400-18a8e30fbae6d1%22%7D; zsxq_access_token=B7BCA2DE-D7BF-8099-7204-6E29433FBAC9_120FAD587DD5E028; abtest_env=product; zsxqsessionid=52ad5e291b0e3d958e0936aa5e58c472");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588422114482814/comments");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415428418581518%22%2C%22first_id%22%3A%2218a8e30fbad520-0f1535de6db44a-26031f51-3686400-18a8e30fbae6d1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fwww.yuque.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhOGUzMGZiYWQ1MjAtMGYxNTM1ZGU2ZGI0NGEtMjYwMzFmNTEtMzY4NjQwMC0xOGE4ZTMwZmJhZTZkMSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQxNTQyODQxODU4MTUxOCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415428418581518%22%7D%2C%22%24device_id%22%3A%2218a8e30fbad520-0f1535de6db44a-26031f51-3686400-18a8e30fbae6d1%22%7D; zsxq_access_token=B7BCA2DE-D7BF-8099-7204-6E29433FBAC9_120FAD587DD5E028; abtest_env=product; zsxqsessionid=52ad5e291b0e3d958e0936aa5e58c472");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\"req_data\":{\"text\":\"你牛比\\n\",\"image_ids\":[],\"mentioned_user_ids\":[]}}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
