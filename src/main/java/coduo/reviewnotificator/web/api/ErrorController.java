package coduo.reviewnotificator.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import coduo.reviewnotificator.web.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> invokeIllegalStateException(IllegalStateException e) {
        log.warn(e.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> invokeIllegalArgumentException(IllegalArgumentException e) {
        log.warn(e.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> invokeBindException(BindException e) {
        log.warn(e.getMessage());

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> invokeUnknownException(Exception e) {
        log.error(e.getMessage());

        return ResponseEntity.internalServerError()
                .body(new ErrorResponse(e.getMessage()));
    }
}
