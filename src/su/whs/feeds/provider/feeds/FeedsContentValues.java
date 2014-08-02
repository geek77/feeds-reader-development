package su.whs.feeds.provider.feeds;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;

import su.whs.feeds.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code feeds} table.
 */
public class FeedsContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return FeedsColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, FeedsSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public FeedsContentValues putTitle(String value) {
        mContentValues.put(FeedsColumns.TITLE, value);
        return this;
    }

    public FeedsContentValues putTitleNull() {
        mContentValues.putNull(FeedsColumns.TITLE);
        return this;
    }


    public FeedsContentValues putAuthor(String value) {
        if (value == null) throw new IllegalArgumentException("value for author must not be null");
        mContentValues.put(FeedsColumns.AUTHOR, value);
        return this;
    }



    public FeedsContentValues putContent(String value) {
        if (value == null) throw new IllegalArgumentException("value for content must not be null");
        mContentValues.put(FeedsColumns.CONTENT, value);
        return this;
    }



    public FeedsContentValues putDate(Date value) {
        if (value == null) throw new IllegalArgumentException("value for date must not be null");
        mContentValues.put(FeedsColumns.DATE, value.getTime());
        return this;
    }


    public FeedsContentValues putDate(long value) {
        mContentValues.put(FeedsColumns.DATE, value);
        return this;
    }


    public FeedsContentValues putAttributes(String value) {
        mContentValues.put(FeedsColumns.ATTRIBUTES, value);
        return this;
    }

    public FeedsContentValues putAttributesNull() {
        mContentValues.putNull(FeedsColumns.ATTRIBUTES);
        return this;
    }


    public FeedsContentValues putAttachments(String value) {
        if (value == null) throw new IllegalArgumentException("value for attachments must not be null");
        mContentValues.put(FeedsColumns.ATTACHMENTS, value);
        return this;
    }



    public FeedsContentValues putActions(String value) {
        mContentValues.put(FeedsColumns.ACTIONS, value);
        return this;
    }

    public FeedsContentValues putActionsNull() {
        mContentValues.putNull(FeedsColumns.ACTIONS);
        return this;
    }

}
