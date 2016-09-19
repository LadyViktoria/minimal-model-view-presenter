package com.example.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity
public class TimeActivity extends AppCompatActivity implements TimePresenter.View {

    @Bean
    TimePresenter presenter;

    @ViewById
    TextView timeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);

        presenter.onViewCreated(this);
    }


    @Override
    public void showTime(String dateString) {
        timeTxt.setText(dateString);
    }
}
