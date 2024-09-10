package com.assignment.amazncart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyConverter implements CurrencyConverterInterface {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    private String API_KEY;

    private String API_URL = "https://api.apilayer.com/exchangerates_data/latest";

    @Override
    public Double convertToInr(Double price, String currency) {
        if ("INR".equals(currency)) {
            return price;  // No conversion needed if the currency is already INR
        }
        // Fetch exchange rates from the API
        Map<String, Double> exchangeRates = getExchangeRates();
        if (exchangeRates == null) {
            throw new RuntimeException("Failed to fetch exchange rates");
        }
        // exchange Rate API : '1' INR -> 'x' OTHER
        // 1 OTHER = '1/x' INR
        return price / exchangeRates.getOrDefault(currency, 1.0);  // Convert to INR
    }

    private Map<String, Double> getExchangeRates() {
        try {
            System.out.println(API_KEY);
            System.out.println(API_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.set("apikey", API_KEY);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = API_URL + "?base=INR";
            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
            if(response.getBody()!=null && response.getBody().containsKey("rates")) {}
                return (Map<String, Double>) response.getBody().get("rates");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
