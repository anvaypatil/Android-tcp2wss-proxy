package connect.vnc.android.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import connect.vnc.android.task.StartServerAsyncTask;
import connect.vnc.android.task.StopServerAsyncTask;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button stopButton;
    EditText web_port;
    EditText vnc_port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.start_server_button);
        stopButton = (Button) findViewById(R.id.stop_server_button);
        web_port = (EditText) findViewById(R.id.web_port);
        vnc_port = (EditText) findViewById(R.id.vnc_port);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String web_prt = web_port.getText().toString();
                String vnc_prt = vnc_port.getText().toString();
                try {
                    new StartServerAsyncTask().execute(new String[]{web_prt, "localhost", vnc_prt});
                    Toast.makeText(MainActivity.this, "Starting the Server on Web Port: " + web_prt + ", VNC running on Port: " + vnc_prt, Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error in starting Server", Toast.LENGTH_LONG).show();
                }

            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new StopServerAsyncTask().execute();
            }
        });
    }
}
