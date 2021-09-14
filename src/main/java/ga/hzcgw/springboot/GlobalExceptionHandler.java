package ga.hzcgw.springboot;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String bindExceptionHandler(BindException bindException) {

        BindingResult bindingResult = bindException.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String message = fieldError.getDefaultMessage();

        return message;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception ex) {
        return "全局异常返回值。。。";
    }
}
