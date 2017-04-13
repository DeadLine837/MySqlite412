package com.tgdz.my.mysqlite412;

import com.tgdz.my.mysqlite412.fm.FmFour;
import com.tgdz.my.mysqlite412.fm.FmOne;
import com.tgdz.my.mysqlite412.fm.FmThree;
import com.tgdz.my.mysqlite412.fm.FmTwo;

public class TabDb {
	/***
	 * 获得底部所有项
	 */
	public static String[] getTabsTxt() {
		String[] tabs = {"首页","添加","收藏","我的"};
		return tabs;
	}
	/***
	 * 获得所有碎片
	 */
	public static Class[] getFramgent(){
		Class[] cls = {FmOne.class,FmTwo.class,FmThree.class,FmFour.class};
		return cls ;
	}
	/***
	 * 获得所有点击前的图片
	 */
	public static int[] getTabsImg(){
		int[] img = {R.mipmap.home1, R.mipmap.add1, R.mipmap.product1, R.mipmap.user1};
		return img ;
	}
	/***
	 * 获得所有点击后的图片
	 */
	public static int[] getTabsImgLight(){
		int[] img = {R.mipmap.home2, R.mipmap.add2, R.mipmap.product2, R.mipmap.user2};
		return img ;
	}
}
