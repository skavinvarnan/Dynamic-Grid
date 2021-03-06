package com.skvarnan.dynamic.grid.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.skvarnan.dynamic.grid.R;
import com.skvarnan.dynamic.grid.model.DemoItem;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DefaultListAdapter extends ArrayAdapter<DemoItem> implements DemoAdapter {

  private final LayoutInflater layoutInflater;

  public DefaultListAdapter(Context context, List<DemoItem> items) {
    super(context, 0, items);
    layoutInflater = LayoutInflater.from(context);
  }

  public DefaultListAdapter(Context context) {
    super(context, 0);
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View v;

    DemoItem item = getItem(position);

    if (convertView == null) {
      v = layoutInflater.inflate(R.layout.adapter_item, parent, false);
    } else {
      v = convertView;
    }

    ImageView image;
    image = (ImageView) v.findViewById(R.id.image);

    Picasso.with(getContext()).load(item.getImageUrl()).placeholder(R.drawable.ic_launcher).error(R.drawable.cat).into(image);

    return v;
  }

  @Override public int getViewTypeCount() {
    return 2;
  }

  @Override public int getItemViewType(int position) {
    return position % 2 == 0 ? 1 : 0;
  }

  public void appendItems(List<DemoItem> newItems) {
    addAll(newItems);
    notifyDataSetChanged();
  }

  public void setItems(List<DemoItem> moreItems) {
    clear();
    appendItems(moreItems);
  }
}