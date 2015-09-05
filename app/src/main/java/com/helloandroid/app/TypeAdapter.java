package com.helloandroid.app;

import android.content.Context;
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

    private Context context;

    public TypeAdapter(Context context) {
        this.context = context;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_type, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.typeText.setText("butterknife");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.type_text) TextView typeText;

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
