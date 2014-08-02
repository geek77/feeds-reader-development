package su.whs.feeds.provider.feeds;

import java.util.Date;

import android.database.Cursor;

import su.whs.feeds.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code feeds} table.
 */
public class FeedsCursor extends AbstractCursor {
    public FeedsCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    public String getTitle() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.TITLE);
        return getString(index);
    }

    /**
     * Get the {@code author} value.
     * Cannot be {@code null}.
     */
    public String getAuthor() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.AUTHOR);
        return getString(index);
    }

    /**
     * Get the {@code content} value.
     * Cannot be {@code null}.
     */
    public String getContent() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.CONTENT);
        return getString(index);
    }

    /**
     * Get the {@code date} value.
     * Cannot be {@code null}.
     */
    public Date getDate() {
        return getDate(FeedsColumns.DATE);
    }

    /**
     * Get the {@code attributes} value.
     * Can be {@code null}.
     */
    public String getAttributes() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.ATTRIBUTES);
        return getString(index);
    }

    /**
     * Get the {@code attachments} value.
     * Cannot be {@code null}.
     */
    public String getAttachments() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.ATTACHMENTS);
        return getString(index);
    }

    /**
     * Get the {@code actions} value.
     * Can be {@code null}.
     */
    public String getActions() {
        Integer index = getCachedColumnIndexOrThrow(FeedsColumns.ACTIONS);
        return getString(index);
    }
}
