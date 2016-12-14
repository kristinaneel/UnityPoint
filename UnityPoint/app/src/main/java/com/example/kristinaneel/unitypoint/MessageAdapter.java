package com.example.kristinaneel.unitypoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by cutle on 12/13/2016.
 */

public class MessageAdapter extends BaseAdapter {
    private Context myContext;
    private Messages[] myMessages;

    public MessageAdapter(Context context, Messages [] messages){
        myContext = context;
        myMessages = messages;
    }
    @Override
    public int getCount(){
        return 0;
    }
    @Override
    public Object getItem(int position){
        return myMessages[position];
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(myContext).inflate(R.layout.message_list_item, null);
            holder = new ViewHolder();
            holder.messageView = (TextView) convertView.findViewById(R.id.messageView);
            holder.messagesCell = (RelativeLayout) convertView.findViewById(R.id.messagesCell);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Messages messages = myMessages[position];
        holder.messageView.setText(messages.getSender());
        holder.messageView2.setText(messages.getText());
        return convertView;
    }
    private static class ViewHolder {
        TextView messageView;
        TextView messageView2;
        RelativeLayout messagesCell;
    }

}
