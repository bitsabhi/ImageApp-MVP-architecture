package com.doctoranywhere.app.mvp;

import com.doctoranywhere.app.Factory;
import com.doctoranywhere.app.concurrency.ExecutorUtils;
import com.doctoranywhere.app.models.UserResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;

/**
 * Created by Admin on 11/26/2017.
 */
public class MainInteractor {
    private ArrayList<UserResult> mList = new ArrayList<>(20);

    interface OnFinishedListener {
        void onSuccess(ArrayList<UserResult> items);
        void onFailure(Throwable t);

    }
    public void makeAPICall(int offset, final OnFinishedListener listener) {
        ListenableFuture<ArrayList<UserResult>> future = Factory.getsUserService().getUserList(offset);
        Futures.addCallback(future, new FutureCallback<ArrayList<UserResult>>() {
            @Override
            public void onSuccess(ArrayList<UserResult> result) {
                mList.addAll(result);
                listener.onSuccess(mList);

            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        }, ExecutorUtils.getUIThread());

    }
}
