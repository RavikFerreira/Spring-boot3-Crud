package br.com.springbootcrud.projectspringbootcrud;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class ProjectSpringBootCrudApplicationTests implements BeforeAllCallback {

    private static AtomicBoolean containerStarter = new AtomicBoolean(false);

    private static GenericContainer<?> redis = new GenericContainer<>(DockerImageName.parse("redis")).
    withExposedPorts(8081).
    withCommand("redis-server --requirepass 12345");

    @Override
    public void beforeAll(ExtensionContext arg0) throws Exception {
        if(!containerStarter.get()){
            redis.start();

            System.setProperty("spring.redis.host",redis.getContainerId());
            System.setProperty("spring.redis.port",redis.getFirstMappedPort().toString());
            System.setProperty("spring.redis.password","12345");

            containerStarter.set(true);
        }
    }
    
}
