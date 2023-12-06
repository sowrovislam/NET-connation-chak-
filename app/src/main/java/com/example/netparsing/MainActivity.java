package com.example.netparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);









    }


    // xml  a on  click  mathod a >>>>>>>>    android:onClick="onclick">>>>>>>>>> ata te click  korle nichar mathod ta on hobe
    // tar por baki sob  thik  thakbe 


    public void onclick(View view) {

        if (! isConnected(this)){

            costomdailog();

        }

    }



    private boolean isConnected(MainActivity mainActivity) {

        ConnectivityManager connectivityManager= (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

      NetworkInfo wificonnation=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
      NetworkInfo mobileconnation=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

      if ((wificonnation!=null&& wificonnation.isConnected()  || mobileconnation!=null&&mobileconnation.isConnected())){


     return true;

      }else
          return false;


    }



    private void costomdailog() {

        new AlertDialog.Builder(MainActivity.this)

                .setMessage("plase connacted to  internet connation")
                .setCancelable(false)
                .setPositiveButton("Connacted", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(Settings.ACTION_WEBVIEW_SETTINGS));

                    }
                })

                .setNegativeButton("cencle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .show();



    }


}



