package com.jkuhail.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

//TODO: Implement the TaskDelegate interface
public class MainActivity extends AppCompatActivity implements TaskDelegate {

    private AsyncTaskExample mAsyncTaskExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Integer[] integers = {1 , 2};

        //TODO: This is all you need to perform a background operation using AsyncTask
        mAsyncTaskExample = new AsyncTaskExample(this);
        mAsyncTaskExample.execute(integers);
    }

    //TODO: Here we shutdown the AsyncTask if the activity stopped.
    @Override
    protected void onStop() {
        super.onStop();
        if(mAsyncTaskExample != null)
            // 'true' means that it can be stopped regardless if the task is done or not
            mAsyncTaskExample.cancel(true);

    }

    @Override
    public void onOperationDone(Integer integer) {
        Toast.makeText(getApplicationContext(), "The result is: " + integer , Toast.LENGTH_SHORT).show();

        //if you are using a recyclerview, here you add the result to the original list and notify the adapter.
    }
}