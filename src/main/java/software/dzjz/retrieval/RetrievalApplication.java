package software.dzjz.retrieval;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication(scanBasePackages = {"software.dzjz.retrieval"})
@MapperScan("software.dzjz.retrieval.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RetrievalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetrievalApplication.class, args);
    }

}
