/*
 * JsonParser.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.example.githubtrendingcli.util;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

/**
 * JsonParser.java
 *
 * @author Nguyen
 */
public class JsonParser {
    public static void parse(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);
        JsonNode items = root.get("items");

        for (JsonNode repo : items) {
            String name = repo.get("full_name").asText();
            String desc = repo.get("description").asText();
            int stars = repo.get("stargazers_count").asInt();
            String lang = repo.get("language").asText("N/A");

            System.out.println("==================================");
            System.out.println("📦 " + name);
            System.out.println("⭐ Stars: " + stars);
            System.out.println("🧠 Language: " + lang);
            System.out.println("📝 " + desc);
        }
    }
}
