package com.linkedin.drelephant.purge;

import common.DBTestUtil;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.test.FakeApplication;
import play.test.Helpers;


import static common.TestConstants.*;
import static org.junit.Assert.assertTrue;

import static common.DBTestUtil.initDB;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

public class AppResultPurgerTest {

    public static FakeApplication app;

    @BeforeClass
    public static void startApp() {
        app = fakeApplication(DBTestUtil.dbConn());
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(app);
    }

    @Test
    public void lowRetentionHasDeletion() {

        running(testServer(TEST_SERVER_PORT, app), new Runnable() {
            public void run() {
                populateTestData();

                PurgeResult result = new AppResultPurger().purgeOlderThan(1, 2, DateTime.now());

                assertTrue("All records were deleted", result.getNumRecordsDeleted() == 2);
                assertTrue("One batch of deletion were performed", result.getNumBatches() == 1);
            }
        });
    }

    private void populateTestData() {
        try {
            initDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
