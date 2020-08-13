package com.jkuhail.asynctask;

/**
 * This interface is for returning the values from the AsyncTask to the main thread.
 */
public interface TaskDelegate {

    void onOperationDone(Integer integer);
}
