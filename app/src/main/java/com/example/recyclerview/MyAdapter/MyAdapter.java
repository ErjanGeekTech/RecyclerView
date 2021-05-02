package com.example.recyclerview.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.ModelClasses.ImageModel;
import com.example.recyclerview.ModelClasses.SimpleText_Model;
import com.example.recyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int textModelVar = 0;
    private final int imageModelVar = 1;

    List<Object> objectsListItems;

    public MyAdapter(List<Object> objectsListItems, Context context) {
        this.objectsListItems = objectsListItems;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (objectsListItems.get(position) instanceof SimpleText_Model) {
            return textModelVar;
        } else if (objectsListItems.get(position) instanceof ImageModel){
            return imageModelVar;
        }else {
            return -1;
        }
    }

    Context context;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View modelView;
        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == textModelVar) {
            modelView = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_text_model, parent, false);
            viewHolder = new SimpleTextVH(modelView);
        }else if (viewType == imageModelVar){
            modelView= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_model, parent, false);
            viewHolder= new ImageVH((modelView));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == textModelVar){
            SimpleText_Model objectSimpleTextModel = (SimpleText_Model) objectsListItems.get(position);
            SimpleTextVH objectSimpleTextVH = (SimpleTextVH) holder;

            objectSimpleTextVH.userNameTV.setText(objectSimpleTextModel.getUserName());
            objectSimpleTextVH.userEmailTV.setText(objectSimpleTextModel.getUserEmail());

        }else if (holder.getItemViewType() == imageModelVar){
            ImageModel objectImageHolder = (ImageModel) objectsListItems.get(position);
            ImageVH objectImageVH= (ImageVH) holder;

            objectImageVH.imageView.setImageResource(objectImageHolder.getImageLink());
        }
    }

    @Override
    public int getItemCount() {
        return objectsListItems.size();
    }

    public class SimpleTextVH extends RecyclerView.ViewHolder {

        TextView userNameTV, userEmailTV;
        public SimpleTextVH(@NonNull View itemView) {
            super(itemView);
            userNameTV = itemView.findViewById(R.id.textModule_username);
            userEmailTV = itemView.findViewById(R.id.textModule_email);
        }
    }

    public class ImageVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ImageVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageModel1_jpg);
        }
    }


}
