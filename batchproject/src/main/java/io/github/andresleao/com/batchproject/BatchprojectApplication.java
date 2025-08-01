package io.github.andresleao.com.batchproject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchprojectApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

//	@Autowired
//	@Qualifier("helloJob")
//	private Job job;

//	@Autowired
//	@Qualifier("readFixedWidthFileJob")
//	private Job job;

//	@Autowired
//	@Qualifier("readDelimitedFileJob")
//	private Job job;

//	@Autowired
//	@Qualifier("readMultiFormatFileJob")
//	private Job job;

//	@Autowired
//	@Qualifier("jdbcCursorReaderJob")
//	private Job job;

	@Autowired
	@Qualifier("jdbcPagingReaderJob")
	private Job job;


//	private static final Logger logger = LoggerFactory.getLogger(BatchprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BatchprojectApplication.class, args);
//		SpringApplication app = new SpringApplication(BatchprojectApplication.class);
//
//		app.setDefaultProperties(
//				Map.of("spring.config.location", "file:///C:/raro/batchproject/batchproject/etc/config/batchproject/application.yml")
//		);
//
//		ConfigurableApplicationContext ctx = app.run(args);
//
//		String url = ctx.getEnvironment().getProperty("spring.datasource.jdbcUrl");
//		System.out.println(">>>> URL DO BANCO: " + url);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters parameters = new JobParametersBuilder()
				//.addString("name", "André", true) // helloJob
				//.addString("clientsFile", "file:files/clientes.txt")
				//.addString("clientsFile", "file:files/clientes_delimitado.txt")
				//.addString("clientsFile", "file:files/clientes_multiformats.txt")
				//.addString("clientsFiles", "file:files/clients*")
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters();

		jobLauncher.run(job, parameters);
	}
}
