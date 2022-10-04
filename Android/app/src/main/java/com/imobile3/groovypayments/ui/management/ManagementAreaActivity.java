package com.imobile3.groovypayments.ui.management;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.ui.BaseActivity;

/* This is supposed to be the activity to change language from english to
*  other specified language. However, I was not able to finish the task
*  that allows the user to change language at runtime */

public class ManagementAreaActivity extends BaseActivity{

    CardView englishCard, spanishCard, filipinoCard;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_area);

        englishCard = findViewById(R.id.englishCard);

        spanishCard = findViewById(R.id.spanishCard);

        filipinoCard = findViewById(R.id.filipinoCard);

        handleChangeLanguageBtn();
        setUpMainNavBar();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase));
    }

    private void handleChangeLanguageBtn() {
        englishCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLanguage("en");
            }
        });

        spanishCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLanguage("es");
            }
        });

        filipinoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLanguage("fil-rPH");
            }
        });
    }

    private void updateLanguage(String langCode) {
        context = LocalHelper.setLocale(this, langCode);
        resources = context.getResources();
    }

    @Override
    protected void initViewModel() {
        //nothing needed
    }

    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showLogo();
        mMainNavBar.showSubtitle(getString(R.string.management_subtitle));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}