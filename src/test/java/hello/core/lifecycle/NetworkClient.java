package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient(){

        System.out.println("url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url){
        this.url = url;

    }

    public void connect(){

        System.out.println("Connect  /"+url);
    }

    public void call(String message){
        System.out.println("call: "+ url + "   message ="+message);
    }


    public void disconnect(){
        System.out.println("close:" + url);

    }
    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
//// implements InitializingBean, DisposableBean
//// 의 존 관개 주입 끝나면 호출됨
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
//// 빈 종료시
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
