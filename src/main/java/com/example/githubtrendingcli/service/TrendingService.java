/*
 * TrendingService.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.githubtrendingcli.service;


import com.example.githubtrendingcli.util.JsonParser;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

/**
 * TrendingService.java
 *
 * @author Nguyen
 */
public class TrendingService {
    public void fetchTrending(String duration, int limit) throws Exception {
        String date = calculateDate(duration);

        String query = "created:>" + date;
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);

        String url = "https://api.github.com/search/repositories?q="
                + encodedQuery
                + "&sort=stars&order=desc&per_page=" + limit;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Github API error: " + response.statusCode());
        }

        JsonParser.parse(response.body());
    }

    private String calculateDate(String duration) {
        LocalDate now = LocalDate.now();

        return switch (duration.toLowerCase()) {
            case "day" -> now.minusDays(1).toString();
            case "week" -> now.minusDays(7).toString();
            case "month" -> now.minusDays(30).toString();
            case "year" -> now.minusDays(365).toString();
            default -> throw new RuntimeException("Invalid duration");
        };
    }
}
