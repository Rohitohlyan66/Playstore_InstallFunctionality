package com.example.playstore_buttons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cancel, install;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancel = findViewById(R.id.cancel);
        install = findViewById(R.id.install);

        install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LinearLayout.LayoutParams cancelParams = new LinearLayout.LayoutParams(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()), 1f);
                cancelParams.setMargins(12, 0, 12, 0);
                LinearLayout.LayoutParams installParams = new LinearLayout.LayoutParams(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()), 1f);
                installParams.setMargins(12, 0, 12, 0);

                cancel.setLayoutParams(cancelParams);
                install.setLayoutParams(installParams);

                cancel.setText(getResources().getString(R.string.cancel));
                install.setText(getResources().getString(R.string.open));
                install.setTextColor(getResources().getColor(R.color.dark_grey));
                install.setBackgroundResource(R.drawable.button_open_inactive);
                install.setClickable(false);
                install.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        install.setText(getResources().getString(R.string.open));
                        install.setTextColor(getResources().getColor(R.color.white));
                        install.setBackgroundResource(R.drawable.button_install);
                        install.setClickable(false);
                        install.setEnabled(false);
                        cancel.setText(getResources().getString(R.string.Uninstall));
                    }
                }, 5000);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams cancelParams = new LinearLayout.LayoutParams(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()), 0f);
                LinearLayout.LayoutParams installParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics()), 2f);
                installParams.setMargins(12, 0, 12, 0);

                cancel.setLayoutParams(cancelParams);
                install.setLayoutParams(installParams);
                install.setText(getResources().getString(R.string.Install));
                install.setTextColor(getResources().getColor(R.color.white));
                install.setBackgroundResource(R.drawable.button_install);
                install.setClickable(true);
                install.setEnabled(true);
            }
        });
    }
}