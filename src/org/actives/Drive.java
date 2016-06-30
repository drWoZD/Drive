package org.actives;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import org.net.Sender;

public class Drive extends Activity implements SensorEventListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drive_layout);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {

    }

    private Sender sender;
}
