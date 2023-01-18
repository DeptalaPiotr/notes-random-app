package pl.deptala.piotr.notesrandomapp.web.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.deptala.piotr.notesrandomapp.api.exception.NoteNotFoundException;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
    public static final String DEFAULT_ERROR_VIEW = "global-error";

    //    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(NoteNotFoundException.class)
    public void handleConflict() {
        LOGGER.info("handleConflict()");
        LOGGER.info("handleConflict(...)");
    }

    @ExceptionHandler(Exception.class)
    public String globalErrorHandler() {
        LOGGER.info("globalErrorHandler()");
        return "global-error.html";
    }

//    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.info("defaultErrorHandler()");
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
//        if (AnnotationUtils.findAnnotation
//                (e.getClass(), ResponseStatus.class) != null)
//            throw e;

        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        LOGGER.info("defaultErrorHandler(...)");
        return mav;
    }
}
