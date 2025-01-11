package com.example.gravity;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class PostAPIAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        try {
            Set<Cookie> cookies = driver.manage().getCookies();
            String apiUrl = "https://ecommerce.example.com/api/add-to-cart";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost postRequest = new HttpPost(apiUrl);

            // Add cookies to the POST request headers
            StringBuilder cookieHeader = new StringBuilder();
            for (Cookie cookie : cookies) {
                cookieHeader.append(cookie.getName()).append("=").append(cookie.getValue()).append("; ");
            }
            postRequest.addHeader("Cookie", cookieHeader.toString());

            // Add JSON payload to the POST request
            String jsonPayload = "{ \"productId\": \"12345\", \"quantity\": 2 }";
            StringEntity entity = new StringEntity(jsonPayload);
            postRequest.setEntity(entity);
            postRequest.setHeader("Content-Type", "application/json");

            // Execute the POST request and handle the response
            CloseableHttpResponse response = httpClient.execute(postRequest);
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                System.out.println("API Response Status: " + response.getStatusLine());
                System.out.println("API Response: " + new String(responseEntity.getContent().readAllBytes()));
            }

            // Step 4: Validate response or perform additional actions
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("API request successful!");
            } else {
                System.out.println("API request failed!");
            }

            // Close HttpClient
            httpClient.close();

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}










