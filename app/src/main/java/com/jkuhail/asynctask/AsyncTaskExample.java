package com.jkuhail.asynctask;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;


/**
 * This is just a template of the ideal way of using AsyncTask.
 *
 * You will notice that there's no actual data. all the data here are just an example.
 * Feel free to change whatever you want to make the template suitable for your app logic.
 *
 *
 * First parameter 'Integer' => The parameters of the 'doInBackground' method.
 * Second parameter 'void' => The parameter of the 'onProgressUpdate' method.
 * Third parameter 'Integer' = > The parameter of the 'onPostExecute' method + The type of 'doInBackground' method.
 *
 */

public class AsyncTaskExample extends AsyncTask<Integer, Void, Integer> {

    private static final String TAG = "AsyncTaskExample";

    //TODO: Here you can implement the variables that we need to it to be modified.
    private WeakReference<TaskDelegate> mDelegate; // we use WeakReference<> to prevent memory leak.


    //TODO: Generate a constructor with the required parameters
    public AsyncTaskExample(TaskDelegate mDelegate) {
        this.mDelegate = new WeakReference<>(mDelegate);
    }

    //TODO: Use this when you want to prepare anything before performing the AsyncTask
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //on main Thread
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        //on main Thread

        //send the result to the main thread
        mDelegate.get().onOperationDone(integer);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        //on main Thread
    }

    //TODO: Use this method to perform the tasks.
    @Override
    protected Integer doInBackground(Integer... integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        //on the background Thread
        return sum;
    }
}
