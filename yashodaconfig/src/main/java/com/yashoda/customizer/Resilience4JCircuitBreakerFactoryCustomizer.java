package com.yashoda.customizer;

import java.time.Duration;
import java.util.function.Consumer;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Component
public class Resilience4JCircuitBreakerFactoryCustomizer implements Customizer<Resilience4JCircuitBreakerFactory> {
	@Override
	public void customize(Resilience4JCircuitBreakerFactory factory) {
		factory.configure(new SlowResilience4JConfigBuilderConsumer(), "slow");
		factory.configure(new FastResilience4JConfigBuilderConsumer(), "fast");
	}

	private final class SlowResilience4JConfigBuilderConsumer implements Consumer<Resilience4JConfigBuilder> {
		@Override
		public void accept(Resilience4JConfigBuilder builder) {
			builder.circuitBreakerConfig(
					CircuitBreakerConfig.custom().failureRateThreshold(3).waitDurationInOpenState(Duration.ofSeconds(2))
							.slidingWindowSize(2).slowCallRateThreshold(3).build())
					.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build());
		}

	}

	private final class FastResilience4JConfigBuilderConsumer implements Consumer<Resilience4JConfigBuilder> {
		@Override
		public void accept(Resilience4JConfigBuilder builder) {
			builder.circuitBreakerConfig(
					CircuitBreakerConfig.custom().failureRateThreshold(3).waitDurationInOpenState(Duration.ofSeconds(1))
							.slidingWindowSize(1).slowCallRateThreshold(2).build())
					.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build());
		}

	}
}
