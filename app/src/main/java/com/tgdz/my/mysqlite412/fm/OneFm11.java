package com.tgdz.my.mysqlite412.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tgdz.my.mysqlite412.R;

public class OneFm11 extends Fragment {

	private String name;

	@Override
	public void setArguments(Bundle args) {
		name = args.getString("name");
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment11, container,false);
		((TextView) view.findViewById(R.id.fm_text)).setText(name+"////");
		return view;
	}

}
