package org.actives;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.net.Sender;

import java.io.IOException;


public class Main extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        connect = (Button) findViewById(R.id.connect);

        connect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                EditText address = (EditText) findViewById(R.id.address);
                EditText port = (EditText) findViewById(R.id.port);
                String address_string = address.getText().toString();
                String port_string = port.getText().toString();
                new ConnectTask().execute(address_string, port_string);
            }
        });
    }

    private class ConnectTask extends AsyncTask<String, String, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            Sender sender = new Sender();

            try {
                sender.setAddress(params[0]);
                sender.setPort(Integer.parseInt(params[1]));
                if (sender.isConnect()) sender.disconnect();
                else sender.connect();
            } catch (IOException exception) {
                return exception.getMessage();
            } catch (NumberFormatException exceptoin) {
                return "You must enter port number";
            }
            return null;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            connect.setText("...");
        }

        @Override
        protected void onPostExecute(String result)
        {
            connect.setText("Connect");
            if (result != null) {
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

            } else {
                //Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();

            }
        }

    }

    private Button connect;
}
