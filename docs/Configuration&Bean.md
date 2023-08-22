# @Configuration & @Bean & @Component
스프링은 기본적으로 `컴포넌트 스캔`을 통해서 컴포넌트(클래스)들을 `스프링 빈`으로 등록합니다.  
`스프링 빈`으로 등록되면 스프링에서 사용하는 `의존성 주입, 싱글톤 관리, AOP 등의 지원 및 다양한 편리한 설정`
을 사용할 수 있기 때문에 빈 등록은 필수적입니다.  

## @Component
`@Component` 어노테이션은 기본적인 빈 등록을 위한 어노테이션으로, `stereotype` 주석을 사용합니다. 
스테레오타입 어노테이션은 빈 등록이나 빈의 역할을 명시적으로 지정하고자 할 때 사용됩니다.
  
주로 서비스 클래스, 리포지토리 클래스, 컨트롤러 클래스들을 `@Component`
어노테이션을 사용하여 등록합니다.

## @Configuration
`@Configuration`은 `JavaConfig` 방식의 설정 클래스를 정의할 때 사용합니다.
`@Bean`을 사용하여 빈을 정의하고 컨테이너에 등록하며, 프로퍼티 설정, 빈 간의 의존성 주입 등을 관리할 수 있습니다.

## @Bean
`@Bean`은 Spring 컨테이너에 의해 관리되는 `빈 객체를 정의하는 매서드`에 붙입니다.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService(); // MyService 객체가 빈으로 등록됨
    }
}
```