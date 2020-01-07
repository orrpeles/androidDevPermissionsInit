package com.example.permissiondemoactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

// ref: https://www.techotopia.com/index.php/Making_Runtime_Permission_Requests_in_Android_6.0
// documentation as to the request and response;
    public class MainActivity extends AppCompatActivity {

        private static String TAG = "PermissionDemo";
        private static final int READ_CONTACTS_REQUEST_CODE = 101;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // Target: check if permission was granted;
                // Make a call to the checkSelfPermission() method of the ContextCompat class;
                // Pass through as arguments a reference to the current activity and the permission being requested
                // Lastly call the request within Main Activity
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission Denied");
            }
            makeRequest();
        }
        //make the request
        protected void makeRequest() {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS_REQUEST_CODE);
        }
        //handle the response
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[] , @NonNull int[] grantResults) {
            switch (requestCode) {
                case READ_CONTACTS_REQUEST_CODE: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Log.i(TAG, "Permission denied");
                    } else {
                        Log.i(TAG, "Permissions granted");
                    }
                    return;

                }
            }
        }
    }
