package org.techtown.misson13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>
    implements OnCustomerItemClickListener {

    ArrayList<Customer> items = new ArrayList<>();
    OnCustomerItemClickListener listener;


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.customer_item, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder( CustomerAdapter.ViewHolder holder, int position) {
        Customer item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Customer item) {
        items.add(item);
    }

    public Customer getItem(int position) {
        return items.get(position);
    }


    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        listener.onItemClick(holder, view, position);
            // listener : main의 익명 객체를 가리킴.
    }

    public void setOnItemClickListener(OnCustomerItemClickListener listener) {
        this.listener = listener; // mainActivity 에서 가져오는 정보.
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;

        public ViewHolder(View itemView, OnCustomerItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // 누른 위치값의 index번호를
                    listener.onItemClick(ViewHolder.this, v, position);
                }
            });
        }

        public void setItem (Customer item) {

            textView.setText(item.getName());
            textView2.setText(item.getBirth());
            textView3.setText(item.getMobile());
            imageView.setImageResource(item.getResId());

        }



    }



}
