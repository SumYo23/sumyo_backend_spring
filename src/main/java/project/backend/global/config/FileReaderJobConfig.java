package project.backend.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.backend.domain.ingredient.dto.IngredientPostRequestDto;
import project.backend.domain.ingredient.service.CsvIngredientWriter;
import project.backend.domain.ingredient.service.CsvReader;

@Configuration
@RequiredArgsConstructor
public class FileReaderJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;
    private final CsvIngredientWriter csvIngredientWriter;

    private static final int chunkSize = 1748; // 데이터 처리할 Row Size

    /**
     * 저장 Job
     * Job은 여러 Step을 가질 수 있음
     */
    @Bean
    public Job csvIngredientJob() {
        return jobBuilderFactory.get("csvIngredientJob")
                .start(csvIngredientReaderStep())
                .build();
    }

    /**
     * csv 파일 읽고 DB에 쓰는 Step
     */
    @Bean
    public Step csvIngredientReaderStep(){
        return stepBuilderFactory.get("csvIngredientReaderStep")
                .<IngredientPostRequestDto, IngredientPostRequestDto>chunk(chunkSize)
                .reader(csvReader.csvIngredientReader()) //추가
                .writer(csvIngredientWriter) //추가
                .build();
    }

}
