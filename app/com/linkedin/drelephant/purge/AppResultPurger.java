package com.linkedin.drelephant.purge;

import models.AppResult;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;


public class AppResultPurger implements ElephantPurger {

    private static final Logger logger = Logger.getLogger(AppResultPurger.class);

    public PurgeResult purgeOlderThan (int days, int batchSize, DateTime startingFrom) {
        int deletedRecords;
        int totalDeletedRecords = 0;
        int deleteBatches = 0;

        do {
            deletedRecords = AppResult.deleteOlderThan(days, batchSize, DateTime.now());
            if (deletedRecords > 0) {
                totalDeletedRecords += deletedRecords;
                deleteBatches++;
            }

            logger.info("Purged " + deletedRecords + " records older than " + days + " from the database");
        } while (deletedRecords > 0);

        return new PurgeResult(totalDeletedRecords, deleteBatches);
    }
}
