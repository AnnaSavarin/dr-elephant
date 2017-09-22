package com.linkedin.drelephant.purge;

import org.joda.time.DateTime;

public interface ElephantPurger {

    PurgeResult purgeOlderThan (int days, int batchSize, DateTime startingFrom);
}
