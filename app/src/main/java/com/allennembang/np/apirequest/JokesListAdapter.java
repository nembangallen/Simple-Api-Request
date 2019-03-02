package com.allennembang.np.apirequest;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Step 1st for recyclerview
 */
public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.JokesViewHolder> {

    /**
     * step 3rd
     */
    List<JokesRP.ValueBean> jokeslist;

    /**
     * step 4th
     * @param jokeslist
     */
    public JokesListAdapter(List<JokesRP.ValueBean> jokeslist) {
        this.jokeslist = jokeslist;
    }

    @NonNull
    @Override
    public JokesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /**
         * step 7
         */
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item_joke,viewGroup,false);
        return new JokesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokesViewHolder jokesViewHolder, int i) {
        /**
         * step 9
         */
        jokesViewHolder.txtJokes.setText(jokeslist.get(i).getJoke());
    }

    @Override
    public int getItemCount() {

        /**
         * step 5th
         */
        return jokeslist.size();
    }

    /**
     * step 2nd
     */
    public class JokesViewHolder extends RecyclerView.ViewHolder {
        /**
         * step 8
         */
        AppCompatTextView txtJokes;
        public JokesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJokes = itemView.findViewById(R.id.txtJokes);
        }
    }
}
