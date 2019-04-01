package org.debugroom.sample.aws.rds.config;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRdsInstance(dbInstanceIdentifier = "sample-rds-postgres",password = "postgresql", readReplicaSupport = false)
public class RdsConfig {
}
