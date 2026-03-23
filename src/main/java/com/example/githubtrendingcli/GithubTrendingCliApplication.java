package com.example.githubtrendingcli;

import com.example.githubtrendingcli.service.TrendingService;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class GithubTrendingCliApplication {

    public static void main(String[] args) {
        Options options = new Options();

        options.addOption("d", "duration", true, "day | week | month | year");
        options.addOption("l", "limit", true, "number of repos");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            String duration = cmd.getOptionValue("duration", "week");
            int limit = Integer.parseInt(cmd.getOptionValue("limit", "10"));

            TrendingService service = new TrendingService();
            service.fetchTrending(duration, limit);

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }

}
