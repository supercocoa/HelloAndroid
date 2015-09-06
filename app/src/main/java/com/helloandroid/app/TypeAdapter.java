package com.helloandroid.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scott on 15/9/5.
 */
public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.CardViewHolder> {

    private Activity activity;
    Config.TypeItem[] TYPE_ITEMS;

    public TypeAdapter(Activity activity, Config.TypeItem[] TYPE_ITEMS) {
        this.activity = activity;
        this.TYPE_ITEMS = TYPE_ITEMS;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_type, parent, false);
        v.setOnClickListener(clickListener);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.typeText.setText(TYPE_ITEMS[position].TITLE);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return TYPE_ITEMS.length;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            Config.TypeItem typeItem = TYPE_ITEMS[position];
            if (typeItem.TARGET != null) {
                Intent intent = new Intent();
                intent.setClass(activity, typeItem.TARGET);
                activity.startActivity(intent);
            }
        }
    };

    public class CardViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.type_text) TextView typeText;

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
