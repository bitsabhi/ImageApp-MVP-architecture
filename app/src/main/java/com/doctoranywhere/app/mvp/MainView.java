package com.doctoranywhere.app.mvp;

import com.doctoranywhere.app.models.UserResult;

import java.util.ArrayList;

/**
 * Created by Admin on 11/26/2017.
 */
public interface MainView {

    void showProgress();

    void hideProgress();

    void setAdapter(ArrayList<UserResult> list);

}
