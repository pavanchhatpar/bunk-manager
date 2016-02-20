package com.bunkmanager.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bunkmanager.R;

import java.util.ArrayList;

/**
 * Created by Pavan on 31/05/2015.
 */
public class InfoRecyclerAdapter extends RecyclerView.Adapter<InfoRecyclerAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    public Activity activity;
    private ArrayList<String> instructions=new ArrayList<String>();
    private ArrayList<String> numbers=new ArrayList<String>();

    public InfoRecyclerAdapter(Activity act){
        this.activity=act;
        mLayoutInflater= LayoutInflater.from(act);
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.instruction_layout,parent,false);

        for(int i=0;i<9;i++){
            numbers.add(String.valueOf(i+1)+". ");
        }
        instructions.add("Go to Subjects section, add subjects using the Floating button");
        instructions.add("Now, in the navigation bar, hit on time table section");
        instructions.add("Once here, using the Floating button, set number of lectures per day, for the entire week at once");
        instructions.add("The app will restart now and take you to the current day");
        instructions.add("You can see a template of the lectures set, hit on 'Add Subject' to set a subject for that lecture");
        instructions.add("Now, you're set, record attended and bunked lectures by hitting the green and red number buttons repectively and" +
                " do a long press on the respective buttons to reduce number by 1");
        instructions.add("Edit subject names and percentage limit on the subjects tab by simply doing a long press on it");
        instructions.add("Definitely the time tables and subjects change over time; long press on a lecture to see more options and at the top of the app, you have a master reset button");
        instructions.add("Can't remember to record daily? Never mind, check out the settings section!");
        Holder holder=new Holder(item);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String link="<a href='http://goo.gl/forms/j0gIXsL2mX'>here</a>";
        holder.cardView.setRadius(20);

        if(position==0){
            holder.number.setVisibility(View.INVISIBLE);
            holder.instruction.setVisibility(View.INVISIBLE);
            holder.welcome.setVisibility(View.VISIBLE);
            holder.intro.setVisibility(View.VISIBLE);
        } else{
            holder.number.setVisibility(View.VISIBLE);
            holder.instruction.setVisibility(View.VISIBLE);
            holder.welcome.setVisibility(View.INVISIBLE);
            holder.intro.setVisibility(View.INVISIBLE);
            if(position==11){
                String string="<br><br><i>developed by Pavan R Chhatpar</i>";
                holder.instruction.setText(Html.fromHtml(string));
                holder.number.setText("  ");

            } else if (position == 10) {
                holder.number.setText("10. ");
                holder.instruction.setClickable(true);
                holder.instruction.setMovementMethod(LinkMovementMethod.getInstance());
                holder.instruction.setText("For future updates to be sent to you, submit your email ID ");
                holder.instruction.append(Html.fromHtml(link));
                holder.instruction.append(". Dont worry, you wont be sent any spam");

            } else {
                    holder.number.setText(numbers.get(position-1));
                    holder.instruction.setText(instructions.get(position-1));

                }
            }
        }



    @Override
    public int getItemCount() {
        return 12;
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView number;
        TextView instruction ;
        TextView welcome;
        TextView intro;
        CardView cardView;
        public Holder(View itemView) {
            super(itemView);
             number =(TextView)itemView.findViewById(R.id.infoNumber);
             instruction =(TextView)itemView.findViewById(R.id.instruction);
             welcome=(TextView)itemView.findViewById(R.id.WelcomeText);
             intro=(TextView)itemView.findViewById(R.id.introText);
            cardView=(CardView)itemView.findViewById(R.id.infoCard);
        }
    }
}