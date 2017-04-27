package connect.vnc.android.task;

import android.os.AsyncTask;

import connect.vnc.android.websockify.WebSockify;

/**
 * Created by newton on 27/4/17.
 */

public class StartServerAsyncTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String[] params) {
        // do above Server call here
        try {
            if(BadPatternHolder.ws!=null)
                BadPatternHolder.ws=new WebSockify();

            BadPatternHolder.ws.doMain(params);
            return "Server Started";
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

