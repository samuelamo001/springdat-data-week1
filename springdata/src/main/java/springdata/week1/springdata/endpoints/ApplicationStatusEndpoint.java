package springdata.week1.springdata.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "application-status")
public class ApplicationStatusEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationStatusEndpoint.class);

    private String statusMessage = "Application is running smoothly";
    private Map<String, String> appMetadata = new HashMap<>();

    public ApplicationStatusEndpoint() {
        appMetadata.put("version", "2.1.0");
        appMetadata.put("description", "Application Status and Configurations");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ReadOperation
    public Map<String, Object> fetchApplicationStatus() {
        logger.info("Read Operation: Fetching application status and metadata");

        Map<String, Object> response = new HashMap<>();
        response.put("message", statusMessage);
        response.put("metadata", appMetadata);
        response.put("timestamp", System.currentTimeMillis());

        return response;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @WriteOperation
    public Map<String, String> updateConfig(@Selector String newStatusMessage) {
        if (newStatusMessage == null || newStatusMessage.isBlank()) {
            logger.warn("Write Operation failed: Invalid input");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status message provided");
        }

        this.statusMessage = newStatusMessage;
        logger.info("Write Operation: Updated application status message to '{}'", newStatusMessage);

        return Map.of("message", "Write operation successful", "newStatusMessage", newStatusMessage);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteOperation
    public Map<String, String> resetApplicationStatus() {
        if ("Application is initializing...".equals(this.statusMessage)) {
            logger.warn("Delete Operation: Application status already reset to default");
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "Application status already reset to default");
        }

        this.statusMessage = "Application is initializing...";
        appMetadata.put("status", "reset to default");

        logger.info("Delete Operation: Application status reset to default");

        return Map.of("message", "Application status reset to default", "statusMessage", statusMessage);
    }

}
