package su.whs.feeds.provider.feeds;

import java.util.HashSet;
import java.util.Set;

import android.net.Uri;
import android.provider.BaseColumns;

import su.whs.feeds.provider.FeedsProvider;

/**
 * Columns for the {@code feeds} table.
 */
public class FeedsColumns implements BaseColumns {
    public static final String TABLE_NAME = "feeds";
    public static final Uri CONTENT_URI = Uri.parse(FeedsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    public static final String _ID = BaseColumns._ID;
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String CONTENT = "content";
    public static final String DATE = "date";
    public static final String ATTRIBUTES = "attributes";
    public static final String ATTACHMENTS = "attachments";
    public static final String ACTIONS = "actions";

    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] FULL_PROJECTION = new String[] {
            TABLE_NAME + "." + _ID + " AS " + BaseColumns._ID,
            TABLE_NAME + "." + TITLE,
            TABLE_NAME + "." + AUTHOR,
            TABLE_NAME + "." + CONTENT,
            TABLE_NAME + "." + DATE,
            TABLE_NAME + "." + ATTRIBUTES,
            TABLE_NAME + "." + ATTACHMENTS,
            TABLE_NAME + "." + ACTIONS
    };
    // @formatter:on

    private static final Set<String> ALL_COLUMNS = new HashSet<String>();
    static {
        ALL_COLUMNS.add(_ID);
        ALL_COLUMNS.add(TITLE);
        ALL_COLUMNS.add(AUTHOR);
        ALL_COLUMNS.add(CONTENT);
        ALL_COLUMNS.add(DATE);
        ALL_COLUMNS.add(ATTRIBUTES);
        ALL_COLUMNS.add(ATTACHMENTS);
        ALL_COLUMNS.add(ACTIONS);
    }

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (ALL_COLUMNS.contains(c)) return true;
        }
        return false;
    }
}
