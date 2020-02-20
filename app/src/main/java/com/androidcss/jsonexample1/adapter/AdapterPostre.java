package com.androidcss.jsonexample1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import com.androidcss.jsonexample1.activity.DetailsActivity;
import com.bumptech.glide.Glide;
import com.androidcss.jsonexample1.R;
import com.androidcss.jsonexample1.model.DataPostre;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by x on 9/7/2016.
 */
public class AdapterPostre extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private LayoutInflater inflater;
    List<DataPostre> data= Collections.emptyList();
    DataPostre current;
    int currentPos=0;
    String url = "https://www.primerpasito.com/testexample/images/";

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterPostre(Context context, List<DataPostre> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_postres, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        final DataPostre current=data.get(position);
        myHolder.textFishName.setText(current.fishName);
        myHolder.textSize.setText( current.sizeName);
        //myHolder.textType.setText("Category: " + current.catName);
        //myHolder.textPrice.setText("Rs. " + current.price + "\\Kg");
        //myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(context).load(url + current.fishImage)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_img_error)
                .error(R.drawable.ic_img_error)
                .into(myHolder.ivFish);


        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " Just cliked item at position " + current.fishName, Toast.LENGTH_LONG).show();


                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("key", current.fishName);
                String imageUrl = url + current.fishImage;
                intent.putExtra("image1",imageUrl);

               // intent.putExtra("IMAGE_URL", imageUrl);

                context.startActivity(intent);



            }
        });

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        ImageView ivFish;
        TextView textSize;
        //TextView textType;
        //TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            //textType = (TextView) itemView.findViewById(R.id.textType);
            //textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

}
