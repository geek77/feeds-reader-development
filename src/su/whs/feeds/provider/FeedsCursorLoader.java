package su.whs.feeds.provider;

import su.whs.feeds.provider.feeds.FeedsColumns;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

public class FeedsCursorLoader extends CursorLoader {

	public FeedsCursorLoader(Context context) {
		super(context);
	}
	
	@Override
    public Cursor loadInBackground() {
      Cursor c = getContext()
    		  .getContentResolver()
    		  .query(
    				  FeedsColumns.CONTENT_URI, 
    				  FeedsColumns.FULL_PROJECTION, 
    				  null, 
    				  null, 
    				  FeedsColumns.DEFAULT_ORDER);
      c.moveToFirst();
      return c;
    }
	
	

}
