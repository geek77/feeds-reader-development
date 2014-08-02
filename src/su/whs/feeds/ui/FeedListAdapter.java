package su.whs.feeds.ui;

import java.text.DateFormat;

import su.whs.feeds.R;
import su.whs.feeds.provider.feeds.FeedsCursor;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeedListAdapter extends CursorAdapter {
	private static final String TAG = "FeedListAdapter";
	private LayoutInflater mInflater = null;
	
	public FeedListAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Log.v(TAG,"creating FeedListAdapter with cursor " + c.getColumnCount());
	}
	
	public class Holder {
		TextView title;
		TextView content;
		TextView timestamp;
		FeedImageView image;
	}

	@Override
	public void bindView(View view, Context context, Cursor c) {
		Holder h = (Holder)view.getTag();
		if (h==null)
			attachHolder(view);		
		FeedsCursor w = new FeedsCursor(c);
		h.title.setText(w.getTitle());
		h.content.setText(Html.fromHtml(w.getContent()));
		h.timestamp.setText(DateFormat.getDateInstance().format(w.getDate()));
		h.image.setImageUrl(getImageFromAttachments(w.getAttachments()));
	}
	
	public static String getImageFromAttachments(String attachments) {
		return null;
	}

	@Override
	public View newView(Context context, Cursor c, ViewGroup parent) {
		View result = mInflater.inflate(R.layout.entry,null);
		attachHolder(result);
		return result;
	}

	private void attachHolder(View view) {
		Holder h = new Holder();
		h.title = (TextView) view.findViewById(R.id.title);
		h.timestamp = (TextView) view.findViewById(R.id.timestamp);
		h.content = (TextView) view.findViewById(R.id.content);
		h.image = (FeedImageView) view.findViewById(R.id.feedImage);
		view.setTag(h);
	}
}
