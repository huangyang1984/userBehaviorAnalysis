package net.ufida.info.mahout.job;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.util.StopWatch;

/**
 * 
 * @author Steven.yang
 *
 */
public class QuartzLedgerJob {
	
	private static final Logger logger = Logger.getLogger(QuartzLedgerJob.class);

	private JobLauncher jobLauncher;

	private Job simpleJob;

	private JobParameters jobParameters = new JobParameters();
	
	
	/**
	 * @param simpleJob the simpleJob to set
	 */
	public void setSimpleJob(Job simpleJob) {
		this.simpleJob = simpleJob;
	}

	/**
	 * @param jobLauncher the jobLauncher to set
	 */
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public void execute() throws Exception {
		logger.info("start...");
		StopWatch sw = new StopWatch();
		sw.start();
		jobLauncher.run(simpleJob, jobParameters);
		sw.stop();
		logger.info(">>> TIME ELAPSED:" + sw.prettyPrint());
	}
}
