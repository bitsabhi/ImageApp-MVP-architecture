package com.doctoranywhere.app.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.doctoranywhere.app.R;
import com.doctoranywhere.app.adapters.UserAdapter;
import com.doctoranywhere.app.models.UserResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private UserAdapter mAdapter;
    private ArrayList<UserResult> mUserList = new ArrayList<>(50);
    private ProgressDialog mPd;
    private int mOffset;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        presenter = new MainPresenter(this, new MainInteractor());

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mPd = new ProgressDialog(this);
        mPd.setMessage("Please wait...");

        mRecyclerView.addOnScrollListener(new MyScrollListener());
        presenter.makeAPICall(mOffset);


    }


    @Override
    public void showProgress() {
        mPd.show();

    }

    @Override
    public void hideProgress() {
        mPd.hide();
    }

    @Override
    public void setAdapter(ArrayList<UserResult> list) {
        mAdapter = new UserAdapter(MainActivity.this, mUserList);
        mRecyclerView.setAdapter(mAdapter);
    }

    class MyScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            visibleItemCount = mRecyclerView.getChildCount();
            totalItemCount = mLayoutManager.getItemCount();
            firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }
            if (!loading && (totalItemCount - visibleItemCount)
                    <= (firstVisibleItem + visibleThreshold)) {
                // End has been reached

                Log.i("Abhi!", "end called");
                Toast.makeText(MainActivity.this, "Loading more items...", Toast.LENGTH_SHORT).show();
                mOffset += 10;
                presenter.makeAPICall(mOffset);
                loading = true;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
