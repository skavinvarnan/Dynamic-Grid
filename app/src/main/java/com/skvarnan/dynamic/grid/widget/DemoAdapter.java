package com.skvarnan.dynamic.grid.widget;

import android.widget.ListAdapter;

import com.skvarnan.dynamic.grid.model.DemoItem;

import java.util.List;


public interface DemoAdapter extends ListAdapter {

  void appendItems(List<DemoItem> newItems);

  void setItems(List<DemoItem> moreItems);
}
