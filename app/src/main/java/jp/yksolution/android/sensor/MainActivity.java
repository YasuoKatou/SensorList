package jp.yksolution.android.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.txtCodeName)).setText(Build.VERSION.CODENAME);
        ((TextView)findViewById(R.id.txtRelease)).setText(Build.VERSION.RELEASE);
        ((TextView)findViewById(R.id.txtSdk)).setText(Integer.toString(Build.VERSION.SDK_INT));
        ((TextView)findViewById(R.id.txtSecurityPatch)).setText(Build.VERSION.SECURITY_PATCH);

        SensorManager sMgr = (SensorManager)getSystemService(SENSOR_SERVICE);
        final List<String> sensorNames = new ArrayList<>();
        for (Sensor sensor : sMgr.getSensorList(Sensor.TYPE_ALL)) {
            sensorNames.add(sensor.getName());
        };
        ListView lv = (ListView) findViewById(R.id.lstSensor);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorNames));
    }
}