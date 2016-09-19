package com.example.mvp;

import com.example.mvp.model.TimeModel;
import com.example.mvp.rest.TimeClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.rest.spring.annotations.RestService;

@EBean
public class TimePresenter {

    @RestService
    TimeClient timeRestClient;

    private View view;

    public void onViewCreated(View view) {
        this.view = view;
        getTime();
    }

    @Background
    void getTime() {
        TimeModel currentUTCTime = timeRestClient.getCurrentUTCTime();
        displayTime(currentUTCTime);
    }

    @UiThread
    void displayTime(TimeModel currentUTCTime) {
        view.showTime(currentUTCTime.getDateString());
    }

    public interface View {
        void showTime(String dateString);
    }

}
