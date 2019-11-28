package com.example.wtpl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    AlertDialog.Builder alertDialog;
    Animation fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.im);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        imageView.setAnimation(fromtop);
    }

    @Override
    public void onBackPressed() {
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("PASSCODE");
        alertDialog.setMessage(" Enter Security Passcode ");
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String password = input.getText().toString();

                        if (password.equals("1234")) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                            View view=toast.getView();
                            view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                            TextView text =view.findViewById(android.R.id.message);
                            text.setTextColor(Color.BLUE);
                            toast.show();
                            finish();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                            View view=toast.getView();
                            view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                            TextView text =view.findViewById(android.R.id.message);
                            text.setTextColor(Color.RED);
                            toast.show();
                        }
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

}
