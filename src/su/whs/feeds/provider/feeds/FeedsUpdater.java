package su.whs.feeds.provider.feeds;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.os.AsyncTask;


public class FeedsUpdater extends AsyncTask<Void,Void,Void> {
	private FeedsUpdaterClient mClient;
	public FeedsUpdater(FeedsUpdaterClient client) {
		super();
		mClient = client;
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		
		if (mClient!=null) {
			ContentResolver cr = mClient.getContext().getContentResolver();
			
			JSONArray ja = FeedsLoader.loadJson(FeedsConstants.UPDATE_URL);
			if (ja!=null&&ja.length()>0) {
				ContentValues[] cvs = new ContentValues[ja.length()];
				for(int i=0; i<ja.length(); i++) {
					try {
						cvs[i] = jsonToFeedEntry(ja.getJSONObject(i));
					} catch (JSONException e) {
						// skip unknown error
					}
				}
				cr.bulkInsert(FeedsColumns.CONTENT_URI, cvs);
			}
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		mClient.onUpdateFinished(false, true);
	}

	private ContentValues jsonToFeedEntry(JSONObject json) {
		ContentValues result = new ContentValues();
		
		result.put(FeedsColumns.TITLE, json.optString(FeedsColumns.TITLE));
		JSONObject author = json.optJSONObject(FeedsColumns.AUTHOR);
		if (author!=null) {
			result.put(FeedsColumns.AUTHOR, author.toString());
		}
		result.put(FeedsColumns.CONTENT, json.optString(FeedsColumns.CONTENT));
		result.put(FeedsColumns.ATTACHMENTS, json.toString());
		result.put(FeedsColumns.DATE, (new Date()).getTime());
		// FIXME
		// result.put(FeedsColumns.DATE, json.op)
		result.put(FeedsColumns.ATTRIBUTES, json.optString(FeedsColumns.ATTRIBUTES));
		return result;
	}

}
