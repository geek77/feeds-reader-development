package su.whs.feeds.ui;

import su.whs.feeds.R;
import su.whs.feeds.provider.FeedsCursorLoader;
import su.whs.feeds.provider.feeds.FeedsUpdater;
import su.whs.feeds.provider.feeds.FeedsUpdaterClient;
import su.whs.feeds.ui.EnhancedListView.OnDismissCallback;
import su.whs.feeds.ui.EnhancedListView.Undoable;
import su.whs.views.pulltorefresh.PullToRefreshBase;
import su.whs.views.pulltorefresh.PullToRefreshBase.OnRefreshListener;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class FeedListFragment extends Fragment implements LoaderCallbacks<Cursor>, FeedsUpdaterClient, OnRefreshListener<EnhancedListView>, OnDismissCallback{
	private static final String TAG = "FeedListFragment";
	private RefreshableListView mList;
	private FeedListAdapter mAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.feeds_list, container, false);
		mList = (RefreshableListView) v.findViewById(R.id.listView);
		mList.setOnRefreshListener(this);
		mList.getRefreshableView().setDismissCallback(this);
		mList.getRefreshableView().enableSwipeToDismiss();
		return v;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((SherlockFragmentActivity)activity).getSupportLoaderManager().initLoader(0, null, this);
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		return new FeedsCursorLoader(getActivity());
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
		if (mAdapter==null) {
			mAdapter = new FeedListAdapter(getActivity(), c, true);
			mList.setAdapter(mAdapter);
		}
		mAdapter.swapCursor(c);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRefresh(PullToRefreshBase<EnhancedListView> refreshView) {
		// store position
		new FeedsUpdater(this).execute();
		// restore position
	}

	@Override
	public Context getContext() {
		return getActivity();
	}

	@Override
	public void onUpdateFinished(boolean error, boolean has_news) {
		mList.onRefreshComplete();
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public Undoable onDismiss(EnhancedListView listView, int position) {
		Log.v(TAG,"onDismiss " + String.valueOf(position));
		return null;
	}
	
}
