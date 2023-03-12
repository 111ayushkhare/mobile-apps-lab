package com.kitertsu9.aniversario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.kitertsu9.aniversario.R.drawable.button_styling2;

public class MainActivity extends AppCompatActivity {

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void next(View view) {

        page += 1;
        TextView textViewHeading = (TextView) findViewById(R.id.heading_text_view);
        TextView textView = (TextView) findViewById(R.id.description_text_view);
        ImageView imageView = (ImageView) findViewById(R.id.image_happy_birthday);
        Button btn = (Button) findViewById(R.id.button);

        if (page == 1) {

            // Heading
            textViewHeading.setText(R.string.quoteOne);
            // Next description
            textView.setText(R.string.briefOne);
            textView.setTextColor(Color.rgb(49, 179, 235));
            textView.setBackgroundResource(R.drawable.description_styling2);
            textView.setGravity(Gravity.CENTER);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_1);
            // page number
            btn.setText(R.string.pageOne);
            btn.setTextSize(24);
            btn.setTextColor(Color.WHITE);
            btn.setBackgroundResource(button_styling2);
            btn.setTranslationZ(16);
        } else if (page == 2) {
            // Heading
            textViewHeading.setText(R.string.quoteTwo);
            // Next description
            textView.setText(R.string.briefTwo);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_2);
            // page number
            btn.setText(R.string.pageTwo);
        } else if (page == 3) {
            // Heading
            textViewHeading.setText(R.string.quoteThree);
            // Next description
            textView.setText(R.string.briefThree);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_3);
            // page number
            btn.setText(R.string.pageThree);
        } else if (page == 4) {
            // Heading
            textViewHeading.setText(R.string.quoteFour);
            // Next description
            textView.setText(R.string.briefFour);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_4);
            // page number
            btn.setText(R.string.pageFour);
        } else if (page == 5) {
            // Heading
            textViewHeading.setText(R.string.quoteFive);
            // Next description
            textView.setText(R.string.briefFive);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_5);
            // page number
            btn.setText(R.string.pageFive);
        } else if (page == 6) {
            // Heading
            textViewHeading.setText(R.string.quoteSix);
            // Next description
            textView.setText(R.string.briefSix);
            // Next image
            imageView.setImageResource(R.drawable.kaustubh_6);
            // page number
            btn.setText(R.string.pageSix);
        } else if (page == 7) {
            // Heading
            textViewHeading.setText(R.string.quoteThEnd);
            // Next description
            textView.setText(R.string.thEnd);
            textView.setTextSize(24);
            // Next image
            imageView.setImageResource(R.drawable.the_end);
            // page number
            btn.setText(R.string.pagethEnd);
        } else if (page == 8) {
            page = 0;
            setContentView(R.layout.activity_main);
        }
    }
}
