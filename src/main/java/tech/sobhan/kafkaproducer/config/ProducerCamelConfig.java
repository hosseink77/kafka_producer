package tech.sobhan.kafkaproducer.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProducerCamelConfig extends RouteBuilder {

    @Value("${producer.start}")
    private String start;

    @Value("${producer.end}")
    private String end;

    @Override
    public void configure() {
        Random random = new Random();
        from(start)
                .process(exchange -> exchange.getIn().setBody(random.nextInt(100)))
                .to(end)
                .log("# ${body}");
    }
}

