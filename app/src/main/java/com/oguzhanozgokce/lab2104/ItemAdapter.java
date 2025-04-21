package com.oguzhanozgokce.lab2104;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.oguzhanozgokce.lab2104.databinding.FootballerItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private  List<Footballer> footballerList = new ArrayList<>();

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final FootballerItemLayoutBinding binding;

        public ItemViewHolder(FootballerItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Footballer footballer) {
            binding.tvName.setText(footballer.getName());
            binding.tvTeam.setText(footballer.getTeam());
            binding.tvCountry.setText(footballer.getCountry());
            binding.tvAge.setText(String.valueOf(footballer.getAge()));
            binding.tvScore.setText(String.valueOf(footballer.getScore()));
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FootballerItemLayoutBinding binding = FootballerItemLayoutBinding.inflate(inflater, parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Footballer currentFootballer = footballerList.get(position);
        holder.bind(currentFootballer);
    }

    @Override
    public int getItemCount() {
        return footballerList.size();
    }

    public void setItems(List<Footballer> newFootballers) {
        ItemDiffCallback diffCallback = new ItemDiffCallback(this.footballerList, newFootballers);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.footballerList.clear();
        this.footballerList.addAll(newFootballers);

        diffResult.dispatchUpdatesTo(this);
    }

    private static class ItemDiffCallback extends DiffUtil.Callback {

        private final List<Footballer> oldList;
        private final List<Footballer> newList;

        public ItemDiffCallback(List<Footballer> oldList, List<Footballer> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Footballer oldFootballer = oldList.get(oldItemPosition);
            Footballer newFootballer = newList.get(newItemPosition);
            return Objects.equals(oldFootballer.getName(), newFootballer.getName()) &&
                    Objects.equals(oldFootballer.getTeam(), newFootballer.getTeam());
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Footballer oldFootballer = oldList.get(oldItemPosition);
            Footballer newFootballer = newList.get(newItemPosition);
            return Objects.equals(oldFootballer.getName(), newFootballer.getName()) &&
                    Objects.equals(oldFootballer.getTeam(), newFootballer.getTeam());

        }
    }
}
