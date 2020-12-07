package ru.bellintegrator.zelenov.practice.successResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.zelenov.practice.exception.ErrorView;

@RestControllerAdvice(basePackages = {"ru.bellintegrator.zelenov.practice"})
public class SuccessResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof ErrorView){
            return o;
        } else {
            if (methodParameter.getGenericParameterType().getTypeName().equals("void")){
                return new SuccessView();
            }
            DataWrapper dataWrapper=new DataWrapper();
            dataWrapper.setData(o);
            return dataWrapper;
        }
    }
}
