package customClasses;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mvcactivity.ProfileDetailsActivity;
import com.example.mvcactivity.R;

import java.util.ArrayList;
import java.util.Collections;

import modelData.profile;
public class customAdapter extends ArrayAdapter<profile> implements View.OnClickListener{

    private ArrayList<profile> dataSet;
    Context hereContext;

    public customAdapter(ArrayList<profile> data, Context context) {
        super(context, R.layout.profile_item);
        this.dataSet = data;
        this.hereContext = context;
    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtSurname;
    }

    @Override
    public void onClick(View view) {
            profile thisProfile = (profile) view.getTag();
            // Create an Intent to start the ProfileDetailsActivity
            Intent intent = new Intent(hereContext, ProfileDetailsActivity.class);
            // Pass the profile data as an extra to the intent
            intent.putExtra("profile",thisProfile);
            hereContext.startActivity(intent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        profile profile = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.profile_item, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.name);
            viewHolder.txtSurname = convertView.findViewById(R.id.surname);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtName.setText(profile.getName());
        viewHolder.txtSurname.setText(profile.getSurname());

        // Return the completed view to render on screen
        return result;
    }
}
