package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //문자를 반환하면 스트링이 화면에 반환된다
//@Controller //컨트롤러인 경우 뷰이름이 반환된다.
public class LogTestController {

    // @Slf4j 사용시 선언 필요없음
    //    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
    //    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        // name = Spring

        //log level 순서 -> trace -> debug -> info -> warn -> error
        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error(" error log={}", name);

        /**
         * 2021-10-13 14:59:09.858  INFO 12048 --- [nio-8080-exec-2] hello.springmvc.basic.LogTestController  :  info log=Spring
         * 현재 실행한 시간, 프로세스 ID, 현재 실행한 쓰레드, 컨트롤러 이름, 메세지 식으로 나옴
         */

        return "ok";
    }
}
