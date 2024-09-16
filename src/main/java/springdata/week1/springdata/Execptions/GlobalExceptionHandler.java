package springdata.week1.springdata.Execptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springdata.week1.springdata.Execptions.doctor.DoctorCreationException;
import springdata.week1.springdata.Execptions.doctor.DoctorErrorResponse;
import springdata.week1.springdata.Execptions.doctor.DoctorNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException exception) {
        logger.error("Doctor not found: {}", exception.getMessage());
        DoctorErrorResponse errorDetails = new DoctorErrorResponse(LocalDateTime.now(), exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorCreationException.class)
    public ResponseEntity<Object> handleDoctorCreationException(DoctorCreationException exception) {
        logger.error("Doctor creation failed: {}", exception.getMessage());
        DoctorErrorResponse errorDetails = new DoctorErrorResponse(LocalDateTime.now(), exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception exception) {
        logger.error("An error occurred: {}", exception.getMessage());
        DoctorErrorResponse errorDetails = new DoctorErrorResponse(LocalDateTime.now(), exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
