package com.wl.analyticxml;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by travel12 on 2016/9/3.
 */
public class AnalyticActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DomjTool tool=new DomjTool();
        tool.getSelectedNodeValue(AnalyticActivity.this);
    }
}
