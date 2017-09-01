package com.project.sample.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleScheduler.class);

    public SampleScheduler() {
	// TODO Auto-generated constructor stub
    }

    public void init() {
	LOGGER.info("[SCHEDULER][SampleScheduler][init]");
    }

    public void execute() {
	long stime = System.currentTimeMillis();
	long etime = 0;
	LOGGER.info("[SCHEDULER][SampleScheduler][START]");
	try {

	} catch (Exception e) {
	    LOGGER.error("[SCHEDULER][SampleScheduler][Exception:"+e.getMessage()+"]",e);
	} finally {
	    etime = System.currentTimeMillis();
	    LOGGER.info("[SCHEDULER][SampleScheduler][END:"+(etime-stime)+"ms]");
	}
    }

    public void destory() {
	LOGGER.info("[SCHEDULER][SampleScheduler][destory]");
    }

}
