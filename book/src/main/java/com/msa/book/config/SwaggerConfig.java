//package com.msa.book.config;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
//import org.springframework.context.annotation.Configuration;
//
//@OpenAPIDefinition(
//        info = @Info(title = "User-Service API 명세서",
//                description = "사용자 어플 서비스 API 명세서",
//                version = "v1"))
//@Configuration
//public class SwaggerConfig {
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .useDefaultResponseMessages(true) // Swagger 에서 제공해주는 기본 응답 코드를 표시할 것이면 true
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.msa.book"))
////                .paths(PathSelectors.any())
////                .build();
//////                .ignoredParameterTypes(java.sql.Date.class)
//////                .forCodeGeneration(true)
//////                .select()
//////                .apis(RequestHandlerSelectors.any())
//////                .paths(PathSelectors.any())
//////                .build()
//////                .enable(true);
////    }
//}
