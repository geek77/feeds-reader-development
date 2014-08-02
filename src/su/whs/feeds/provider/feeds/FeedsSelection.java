package su.whs.feeds.provider.feeds;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import su.whs.feeds.provider.base.AbstractSelection;

/**
 * Selection for the {@code feeds} table.
 */
public class FeedsSelection extends AbstractSelection<FeedsSelection> {
    @Override
    public Uri uri() {
        return FeedsColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code FeedsCursor} object, which is positioned before the first entry, or null.
     */
    public FeedsCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new FeedsCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null}.
     */
    public FeedsCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null}.
     */
    public FeedsCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public FeedsSelection id(long... value) {
        addEquals(FeedsColumns._ID, toObjectArray(value));
        return this;
    }


    public FeedsSelection title(String... value) {
        addEquals(FeedsColumns.TITLE, value);
        return this;
    }

    public FeedsSelection titleNot(String... value) {
        addNotEquals(FeedsColumns.TITLE, value);
        return this;
    }

    public FeedsSelection titleLike(String... value) {
        addLike(FeedsColumns.TITLE, value);
        return this;
    }

    public FeedsSelection author(String... value) {
        addEquals(FeedsColumns.AUTHOR, value);
        return this;
    }

    public FeedsSelection authorNot(String... value) {
        addNotEquals(FeedsColumns.AUTHOR, value);
        return this;
    }

    public FeedsSelection authorLike(String... value) {
        addLike(FeedsColumns.AUTHOR, value);
        return this;
    }

    public FeedsSelection content(String... value) {
        addEquals(FeedsColumns.CONTENT, value);
        return this;
    }

    public FeedsSelection contentNot(String... value) {
        addNotEquals(FeedsColumns.CONTENT, value);
        return this;
    }

    public FeedsSelection contentLike(String... value) {
        addLike(FeedsColumns.CONTENT, value);
        return this;
    }

    public FeedsSelection date(Date... value) {
        addEquals(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection dateNot(Date... value) {
        addNotEquals(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection date(long... value) {
        addEquals(FeedsColumns.DATE, toObjectArray(value));
        return this;
    }

    public FeedsSelection dateAfter(Date value) {
        addGreaterThan(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection dateAfterEq(Date value) {
        addGreaterThanOrEquals(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection dateBefore(Date value) {
        addLessThan(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection dateBeforeEq(Date value) {
        addLessThanOrEquals(FeedsColumns.DATE, value);
        return this;
    }

    public FeedsSelection attributes(String... value) {
        addEquals(FeedsColumns.ATTRIBUTES, value);
        return this;
    }

    public FeedsSelection attributesNot(String... value) {
        addNotEquals(FeedsColumns.ATTRIBUTES, value);
        return this;
    }

    public FeedsSelection attributesLike(String... value) {
        addLike(FeedsColumns.ATTRIBUTES, value);
        return this;
    }

    public FeedsSelection attachments(String... value) {
        addEquals(FeedsColumns.ATTACHMENTS, value);
        return this;
    }

    public FeedsSelection attachmentsNot(String... value) {
        addNotEquals(FeedsColumns.ATTACHMENTS, value);
        return this;
    }

    public FeedsSelection attachmentsLike(String... value) {
        addLike(FeedsColumns.ATTACHMENTS, value);
        return this;
    }

    public FeedsSelection actions(String... value) {
        addEquals(FeedsColumns.ACTIONS, value);
        return this;
    }

    public FeedsSelection actionsNot(String... value) {
        addNotEquals(FeedsColumns.ACTIONS, value);
        return this;
    }

    public FeedsSelection actionsLike(String... value) {
        addLike(FeedsColumns.ACTIONS, value);
        return this;
    }
}
