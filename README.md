# GitHub Trending CLI

CLI application that talks to GitHub API and shows the trending repositories

Project
URL: <a href="https://roadmap.sh/projects/github-trending-cli">https://roadmap.sh/projects/github-trending-cli</a>

## Requirements

Create a command-line interface (CLI) tool that interacts with the GitHub API to retrieve and display trending
repositories. The tool will allow users to specify a time range (day, week, month, or year) to filter the trending
repositories.

The CLI tool will fetch data from the GitHub API and present it in a user-friendly format. The tool should be easy to
use and provide clear output.

- <b>Language</b>: Pick any backend language

- <b>GitHub API</b>: Utilize the GitHub REST API for fetching repository data.

- <b>Authentication</b> : No authentication required for public repositories.

- <b>Time Range Options</b>: Support filtering by day, week, month, and year.

- <b>Data Fetching</b>: Implement error handling for API requests.

- <b>Data Parsing</b>: Parse the JSON response from the GitHub API.

- <b>Sorting</b>: Sort repositories by star count.

- <b>Output Formatting</b>: Display the trending repositories in a clear and readable format (e.g., repository name,
  description,
  number of stars, language).

- Command-Line Arguments:

    - `--duration`: Specifies the time i.e. `day`, `week`, `month`, `year`). Default to `week`.

    - `--limit`: Specifies the number of repositories to display. Default to `10`.

- <b>Error Handling</b>: Implement robust error handling for invalid input and API errors.

- <b>Documentation</b>: Provide clear instructions on how to install and use the tool.

- <b>Example Usage</b>: `trending-repos --duration month --limit 20`

## Run Application

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Build form source

#### 1. Clone repository

```bash
git https://github.com/roadmap-dot-sh/github-trending-cli.git
cd github-trending-cli
```

#### 2. Build the project

```bash
mvn clean package
```

#### 3. Run the tool

```bash
java -jar target/github-trending-cli-0.0.1-SNAPSHOT.jar [options]
```

Example:

```bash
java -jar target/github-trending-cli-0.0.1-SNAPSHOT.jar --duration month --limit 20
```