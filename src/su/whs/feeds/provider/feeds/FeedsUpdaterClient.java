package su.whs.feeds.provider.feeds;

import android.content.Context;

public interface FeedsUpdaterClient {
	public Context getContext();
	public void onUpdateFinished(boolean error, boolean has_news);
}