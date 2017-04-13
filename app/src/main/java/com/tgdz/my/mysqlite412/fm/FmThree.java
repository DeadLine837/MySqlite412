package com.tgdz.my.mysqlite412.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tgdz.my.mysqlite412.R;
import com.tgdz.my.mysqlite412.TabDb;

public class FmThree extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment, container,false);
		((TextView) view.findViewById(R.id.fm_text)).setText(TabDb.getTabsTxt()[2]);
		return view;
	}
}
