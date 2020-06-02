package com.example.batch.job;


import java.io.File;
import java.io.IOException;
import java.io.Writer;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.domain.DataIn;
import com.example.domain.DataOut;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JobBatchConfiguration.class);
    public static final int CHUNK_SIZE = 100;

    @Bean
    public ItemReader<DataIn> reader(DataSource dataSource) {
    	log.info("[reader]dataSource:"+dataSource); 
    	
        JdbcCursorItemReader reader = new JdbcCursorItemReader();
        reader.setDataSource(dataSource);
        reader.setRowMapper(new CustomRowMapper());
        reader.setSql("SELECT text1, text2 FROM infodata");
        
        log.info("[reader]reader:"+reader); 
        return reader;
    }

    @Bean
    public ItemProcessor<DataIn, DataOut> processor() {
    	log.info("[processor]"); 
        return new ItemProcessor<DataIn, DataOut>() {
            @Override
            public DataOut process(DataIn dataIn) throws Exception {
            	log.info("[process]");
            	log.info("[process]dataIn:"+dataIn);
                DataOut dataOut = new DataOut();
                dataOut.setText1(dataIn.getText1().toUpperCase());
                dataOut.setText2(dataIn.getText2());

            	log.info("[process]dataOut:"+dataOut);
                return dataOut;
            }
        };
    }

    @Bean
    public ItemWriter<DataOut> writer() {

        FlatFileItemWriter<DataOut> writer = new FlatFileItemWriter<>();

        FileSystemResource fileSystemResource = new FileSystemResource(new File("output.txt"));
        writer.setResource(fileSystemResource);

        DelimitedLineAggregator<DataOut> delLineAgg = new DelimitedLineAggregator<DataOut>();
        delLineAgg.setDelimiter(",");

        BeanWrapperFieldExtractor<DataOut> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[] {"text1","text2"});
        delLineAgg.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(delLineAgg);

        writer.setHeaderCallback(new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.write("HEADER");
            }
        });


        writer.setFooterCallback(new FlatFileFooterCallback() {
            @Override
            public void writeFooter(Writer writer) throws IOException {
                writer.write("FOOTER");
            }
        });


        return writer;

    }


    @Bean
    public Job sqlExecuteJob(JobBuilderFactory jobs, Step step, JobExecutionListener listener) {


        Job job = jobs.get("job1")
                .listener(listener)
                .flow(step)
                .end()
                .build();

        return job;


    }


    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<DataIn> reader,
                      ItemWriter<DataOut> writer, ItemProcessor<DataIn, DataOut> processor) {

        return stepBuilderFactory.get("step1")
                .<DataIn, DataOut> chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
