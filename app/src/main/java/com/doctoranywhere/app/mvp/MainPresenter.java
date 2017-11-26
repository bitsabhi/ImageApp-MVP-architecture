package com.doctoranywhere.app.mvp;

import android.util.Log;

import com.doctoranywhere.app.models.UserResult;

import java.util.ArrayList;

/**
 * Created by Admin on 11/26/2017.
 */
public class MainPresenter implements MainInteractor.OnFinishedListener {
    private MainView mainView;
    private MainInteractor interactor;

    public MainPresenter(MainView mainView, MainInteractor interactor) {
        this.mainView = mainView;
        this.interactor = interactor;
    }

    public MainView getMainView() {
        return mainView;
    }


    public void makeAPICall(int OffSet) {
        mainView.showProgress();
        interactor.makeAPICall(OffSet, this);
    }

    public void onDestroy() {
        mainView = null;
    }


    public void onFailure(Throwable t) {
        mainView.hideProgress();
        Log.d("AppLog", t.getMessage());
        mainView.hideProgress();
    }

    @Override
    public void onSuccess(ArrayList<UserResult> items) {
        if (mainView != null) {
            mainView.setAdapter(items);
            mainView.hideProgress();
        }
    }
}
