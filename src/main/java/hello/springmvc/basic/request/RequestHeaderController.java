package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value ="myCookie", required = false) String cookie) {

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);

        /**
         * 2021-10-13 17:38:53.029  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : request=org.apache.catalina.connector.RequestFacade@256ef849
         * 2021-10-13 17:38:53.029  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : response=org.apache.catalina.connector.ResponseFacade@47e8af68
         * 2021-10-13 17:38:53.029  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : httpMethod=GET
         * 2021-10-13 17:38:53.029  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : locale=ko_KR
         * 2021-10-13 17:38:53.029  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : headerMap={content-type=[application/json], accept=[text/html], user-agent=[PostmanRuntime/7.28.4], postman-token=[5e1fb22c-ab78-4fd7-9359-e9eb144d6cb5], host=[localhost:8080], accept-encoding=[gzip, deflate, br], connection=[keep-alive]}
         * 2021-10-13 17:38:53.030  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : header host=localhost:8080
         * 2021-10-13 17:38:53.030  INFO 15120 --- [nio-8080-exec-4] h.s.b.request.RequestHeaderController    : myCookie=null
         */

        return "ok";
    }
}
