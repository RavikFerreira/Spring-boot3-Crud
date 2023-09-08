package br.com.springbootcrud.projectspringbootcrud;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = ProjectSpringBootCrudApplication.class)
@ExtendWith({
    ProjectSpringBootCrudApplicationTests.class
})
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@ImportAutoConfiguration
public @interface IntegrationTest {
    
}
