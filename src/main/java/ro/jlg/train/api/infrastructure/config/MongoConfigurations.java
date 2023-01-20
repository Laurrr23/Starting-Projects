package ro.jlg.train.api.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;


@Configuration


public class MongoConfigurations  {
    @Bean
    public MongoTransactionManager mongoTransactionManager (final MongoDatabaseFactory factory) {

        return new MongoTransactionManager(factory);

    }
}
