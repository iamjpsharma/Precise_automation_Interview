package com.interview.preciseautomation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowLocation;
    NfcAdapter nfcAdapter;

    private static final int REQUEST_CODE_PERMISSION = 2;
    private static final int REQUEST_CODE_PERMISSION2 = 3;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    String StPermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    TextView locationfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        locationfile=findViewById(R.id.locationfile);
        locationfile.setText(R.string.locfile);




        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        btnShowLocation = (Button) findViewById(R.id.button);
        final Intent intent= new Intent(this, ServiceTest.class);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), StPermission)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{StPermission},
                                REQUEST_CODE_PERMISSION2);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                startService(intent);

            }
        });



    }

}
