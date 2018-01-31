package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class GetBeanJokeTask extends AsyncTask<Context, Void, String> {
    public GetBeanJokeTask(AsyncResponse response) {
        this.response = response;
    }

    //Interface
    public interface AsyncResponse {
        void processFinish(String output);
    }
    //Asynctask global varuables
    public AsyncResponse response = null;
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context...contents) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            //end of devapp server
            myApiService = builder.build();
        }
        context = contents[0];


        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
           return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        response.processFinish(s);
    }
}

