package cn.ac.yoxin.databinding;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.ac.yoxin.databinding.api.BusInfo;
import cn.ac.yoxin.databinding.api.BusModel;
import cn.ac.yoxin.databinding.databinding.ActivityRecycleBinding;


public class RecycleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<BusInfo.Bus>>, SearchView.OnQueryTextListener {

    private static final String TAG = "RecycleActivity";
    ActivityRecycleBinding binding;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<BusInfo.Bus> myDataset = new ArrayList<>();
    Context context;
    LoaderManager loaderManager;
    static String queryCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);
        binding.search.setOnQueryTextListener(this);
        mRecyclerView = binding.myRecyclerView;

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(0, null, this);
    }

    @Override
    public Loader<List<BusInfo.Bus>> onCreateLoader(int id, Bundle args) {
        Log.d(TAG, "onCreateLoader");
        return new BusLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<List<BusInfo.Bus>> loader, List<BusInfo.Bus> data) {
        Log.d(TAG, "onLoadFinished");
        if (data != null) {
            myDataset.clear();
            myDataset.addAll(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<BusInfo.Bus>> loader) {
        myDataset.clear();
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onLoaderReset");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        queryCity = query;
        loaderManager.restartLoader(0, null, this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //TODO 城市名智能提示
        return false;
    }


    static class BusLoader extends AsyncTaskLoader<List<BusInfo.Bus>> {

        public BusLoader(Context context) {
            super(context);
        }

        @Override
        public List<BusInfo.Bus> loadInBackground() {
            return BusModel.getInstance().getBuses(queryCity);
        }

        @Override
        public void deliverResult(List<BusInfo.Bus> data) {
            super.deliverResult(data);
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        protected void onStopLoading() {
            cancelLoad();
        }

        @Override
        protected void onReset() {
            super.onReset();
        }

    }
}
