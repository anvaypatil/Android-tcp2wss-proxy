package connect.vnc.android.task;

import android.os.AsyncTask;

/**
 * Created by newton on 27/4/17.
 */

public class StopServerAsyncTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String[] params) {
        // do above Server call here
        try {
            if(BadPatternHolder.ws!=null)
                BadPatternHolder.ws.closeSocket();
            return "Server Socket Closed";
        } catch (Exception e) {
            e.printStackTrace();
            return "Some Error";
        }
    }

    @Override
    protected void onPostExecute(String message) {
        //process message
    }
}

