package com.example.texttospeech2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;
//rebuilt this app for second time after reintstalling win10 when all projects were deleted
//dated December 2,2020
//at my own house bayalbas

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageButton imageButton;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editTextBox);
        imageButton=findViewById(R.id.speakButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String message=editText.getText().toString().trim();
                textToSpeech= new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        textToSpeech.setLanguage(Locale.ENGLISH);
                        textToSpeech.speak(message,textToSpeech.QUEUE_FLUSH,null);

                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        //dont forget to remove     "super.onBackPressed();"

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("EXIT");
        builder.setMessage("Do you really want to exit ?");
        builder.setCancelable(false);
        // noew lets setup yes no buttons
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}