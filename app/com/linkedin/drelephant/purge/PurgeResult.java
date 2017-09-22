package com.linkedin.drelephant.purge;

public class PurgeResult {

    private int _numRecordsDeleted;
    private int _numBatches;

    public PurgeResult(int numRecordsDeleted, int numBatches) {
        _numRecordsDeleted = numRecordsDeleted;
        _numBatches = numBatches;
    }

    public int getNumRecordsDeleted() { return _numRecordsDeleted; }

    public int getNumBatches() { return _numBatches; }
}
