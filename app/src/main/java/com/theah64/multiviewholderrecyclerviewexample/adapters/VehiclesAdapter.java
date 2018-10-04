package com.theah64.multiviewholderrecyclerviewexample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theah64.multiviewholderrecyclerviewexample.R;
import com.theah64.multiviewholderrecyclerviewexample.models.Bike;
import com.theah64.multiviewholderrecyclerviewexample.models.Car;

import java.util.List;

public class VehiclesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER = 990;
    private static final int BODY = 469;

    private final LayoutInflater inflater;
    private final String carTitle;
    private final String bikeTitle;
    private final List<Car> cars;
    private final List<Bike> bikes;

    public VehiclesAdapter(final Context context, String carTitle, String bikeTitle, List<Car> cars, List<Bike> bikes) {
        this.inflater = LayoutInflater.from(context);

        this.carTitle = carTitle;
        this.bikeTitle = bikeTitle;
        this.cars = cars;
        this.bikes = bikes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == HEADER) {
            final View header = inflater.inflate(R.layout.header_vehicles, viewGroup, false);
            return new HeaderViewHolder(header);
        }

        // ViewType = BODY
        final View body = inflater.inflate(R.layout.body_vehicles, viewGroup, false);
        return new BodyViewHolder(body);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof HeaderViewHolder) {
            // Bind header here
            if (position == 0) {
                ((HeaderViewHolder) viewHolder).tvTitle.setText(carTitle);
            } else {
                ((HeaderViewHolder) viewHolder).tvTitle.setText(bikeTitle);
            }
        } else if (viewHolder instanceof BodyViewHolder) {
            // Bind body here
            final String name = getNameFor(position);
            ((BodyViewHolder) viewHolder).tvName.setText(name);
        }
    }

    private String getNameFor(int position) {
        if (position > 0 && position <= cars.size()) {
            // Car return
            return cars.get(position - 1).getName();
        } else {
            // bike return
            final int pos = position - (cars.size() + 2);
            return bikes.get(pos).getName();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || (position == cars.size() + 1)) {
            return HEADER;
        }
        return BODY;
    }

    @Override
    public int getItemCount() {
        return cars.size() + bikes.size() + 2;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    public class BodyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public BodyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }

}
