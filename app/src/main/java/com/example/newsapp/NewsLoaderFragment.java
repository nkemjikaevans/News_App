package com.example.newsapp;

import android.content.Context;

import com.example.newsapp.Object.News;

import java.util.List;

import static com.example.newsapp.Helper.QueryUtils.fetchNewsData;

/**
 * News loader form fragments
 * Created by Evans on 06/03/2020.
 */

public class NewsLoaderFragment
        extends androidx.loader.content.AsyncTaskLoader<List<News>> {

    private String mUrl;

    /**
     * NewsLoaderFragment constructor
     *
     * @param context  context of app
     * @param queryUrl url string as per user input in SearchView
     */
    public NewsLoaderFragment(Context context, String queryUrl) {
        super(context);
        mUrl = queryUrl;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    /**
     * This method is called to load data from url string in background thread
     *
     * @return News detail in form of List<News>
     */
    @Override
    public List<News> loadInBackground() {

        // If url string is null return null object
        if (mUrl == null) {
            return null;
        }

        // Get the List<News> from URL string queried by user
        return fetchNewsData(mUrl);
    }
}

