package cm.ua.pt.ementasua;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyListFragment extends Fragment {

    ArrayAdapter<String> ementaListAdapter;

    public DailyListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_daily_list, container, false);

        ementaListAdapter = new ArrayAdapter<String>(
                getActivity(), // The current context (this activity)
                R.layout.list_item_day, // The name of the layout ID.
                R.id.itemDayFood, // The ID of the textview to populate.
                new ArrayList<String>());

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listOfDays);
        listView.setAdapter(ementaListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDetailsForEntry( parent.getAdapter().getItem(position).toString(), position );
            }
        });

        String jsonResults = MealsParser.callOpenMeals();

        try {
            String[] entries = MealsParser.getMealDataFromJson(jsonResults);

            ementaListAdapter.clear();
            for(String dayEntry : entries){
                ementaListAdapter.add(dayEntry);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rootView;
    }

    private void showDetailsForEntry(String message, int position) {
        // Create fragment and give it an argument specifying the article it should show
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();

        Meal ementa = MealsParser.getMeal(position);

        args.putInt(DetailsFragment.ARG_POSITION, position);
        args.putString(DetailsFragment.ARG_DATE, ementa.getDate());
        args.putString(DetailsFragment.ARG_NAME, ementa.getName());
        args.putString(DetailsFragment.ARG_TYPE, ementa.getType());
        args.putString(DetailsFragment.ARG_SOPA, ementa.getSopa());
        args.putString(DetailsFragment.ARG_CARNE, ementa.getCarne());
        args.putString(DetailsFragment.ARG_PEIXE, ementa.getPeixe());
        args.putBoolean(DetailsFragment.ARG_ENCERRADA, ementa.getEncerrada());
        detailsFragment.setArguments(args);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.activity_daily_ementas, detailsFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

}
