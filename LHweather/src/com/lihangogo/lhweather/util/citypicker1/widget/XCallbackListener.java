package com.lihangogo.lhweather.util.citypicker1.widget;


public abstract class XCallbackListener {

	protected abstract void callback(Object... obj);

	public void call(Object... obj) {
			callback(obj);
	}

}
