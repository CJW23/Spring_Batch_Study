package com.cjw.springbatch.jobconfig.ex3;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class StepExecutionTestConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    /*@Bean
    public Job stepExecutionJob() {
        return jobBuilderFactory.get("stepExecutionJob")
                .start(stepExecutionSuccessStep1())
                .next(stepExecutionSuccessStep2())
                .build();
    }*/

    @Bean
    public Step stepExecutionSuccessStep1() {
        return stepBuilderFactory.get("stepExecutionSuccessStep1")
                //JobExecutionTest
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("=====================");
                    System.out.println(">> StepExecutionSuccessStep1 ");
                    System.out.println("=====================");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step stepExecutionSuccessStep2() {
        return stepBuilderFactory.get("stepExecutionSuccessStep2")
                //JobExecutionTest
                .tasklet((contribution, chunkContext) -> {
                    throw new RuntimeException("에러 발생");
                }).build();
    }

    @Bean
    public Step stepExecutionSuccessStep3() {
        return stepBuilderFactory.get("stepExecutionSuccessStep3")
                //JobExecutionTest
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("=====================");
                    System.out.println(">> StepExecutionSuccessStep3 ");
                    System.out.println("=====================");
                    return RepeatStatus.FINISHED;
                }).build();
    }
}
