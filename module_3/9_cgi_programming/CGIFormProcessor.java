import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CGIFormProcessor {
    public static void main(String[] args) {
        try {
            // Set content type for HTTP response
            System.out.println("Content-Type: text/html\n");

            // Generate HTML response
            printHTMLHeader();

            // Process form data
            Map<String, String> formData = processFormData();

            // Display processed data
            displayFormData(formData);

            printHTMLFooter();

        } catch (Exception e) {
            // Error handling
            printErrorPage(e);
        }
    }

    private static Map<String, String> processFormData() throws IOException {
        Map<String, String> formData = new HashMap<>();
        String requestMethod = System.getenv("REQUEST_METHOD");

        if ("GET".equals(requestMethod)) {
            // Process GET request
            String queryString = System.getenv("QUERY_STRING");
            formData = parseQueryString(queryString);
        } else if ("POST".equals(requestMethod)) {
            // Process POST request
            String contentLength = System.getenv("CONTENT_LENGTH");
            if (contentLength != null) {
                int length = Integer.parseInt(contentLength);
                InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
                char[] buffer = new char[length];
                reader.read(buffer, 0, length);
                String postData = new String(buffer);
                formData = parseQueryString(postData);
            }
        }

        return formData;
    }

    private static Map<String, String> parseQueryString(String queryString) throws UnsupportedEncodingException {
        Map<String, String> formData = new HashMap<>();
        if (queryString != null && !queryString.isEmpty()) {
            String[] pairs = queryString.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                if (idx > 0 && idx < pair.length() - 1) {
                    String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8);
                    String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8);
                    formData.put(key, value);
                }
            }
        }
        return formData;
    }

    private static void printHTMLHeader() {
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html lang='en'>");
        System.out.println("<head>");
        System.out.println("    <meta charset='UTF-8'>");
        System.out.println("    <title>CGI Form Processor</title>");
        System.out.println("    <style>");
        System.out.println("        body { font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto; padding: 20px; }");
        System.out.println("        .result { background-color: #f4f4f4; padding: 15px; border-radius: 5px; }");
        System.out.println("    </style>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("    <h1>CGI Form Processing Result</h1>");
    }

    private static void displayFormData(Map<String, String> formData) {
        System.out.println("    <div class='result'>");
        System.out.println("        <h2>Submitted Data:</h2>");
        System.out.println("        <ul>");
        
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            System.out.println("            <li><strong>" + 
                escapeHTML(entry.getKey()) + 
                ":</strong> " + 
                escapeHTML(entry.getValue()) + 
                "</li>");
        }
        
        System.out.println("        </ul>");
        System.out.println("    </div>");
    }

    private static void printHTMLFooter() {
        System.out.println("    <p><a href='javascript:history.back()'>Go Back</a></p>");
        System.out.println("</body>");
        System.out.println("</html>");
    }

    private static void printErrorPage(Exception e) {
        System.out.println("Content-Type: text/html\n");
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html lang='en'>");
        System.out.println("<head>");
        System.out.println("    <title>CGI Error</title>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("    <h1>Error Processing Request</h1>");
        System.out.println("    <p>An error occurred: " + escapeHTML(e.getMessage()) + "</p>");
        System.out.println("</body>");
        System.out.println("</html>");
    }

    // Utility method to escape HTML special characters
    private static String escapeHTML(String input) {
        if (input == null) return "";
        return input
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#x27;");
    }
}