package su.whs.feeds.ui;


import su.whs.feeds.R;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

}
