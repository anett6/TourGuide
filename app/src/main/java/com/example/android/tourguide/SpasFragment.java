package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpasFragment extends Fragment {

    public SpasFragment() {
        // Required empty public constructor
    }

    //to avoid hardcode and miss-type
    static final String NAME = "Name";
    static final String DESCRIPTION = "Description";
    static final String OPENING_DETAILS = "Opening_Details";
    static final String CONTACT = "Contact";
    static final String WEBSITE = "Website";
    static final String ADDRESS = "Address";
    static final String IMAGE = "Image";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.spa_name1),
                getString(R.string.spa_description1),
                getString(R.string.spa_opening1),
                getString(R.string.spa_opening_details1),
                getString(R.string.spa_contact1),
                getString(R.string.spa_website1),
                getString(R.string.spa_address1),
                R.drawable.szechenyi_spa_bath));

        locations.add(new Location(getString(R.string.spa_name2),
                getString(R.string.spa_description2),
                getString(R.string.spa_opening2),
                getString(R.string.spa_opening_details2),
                getString(R.string.spa_contact2),
                getString(R.string.spa_website2),
                getString(R.string.spa_address2),
                R.drawable.gellert_thermal_bath));

        locations.add(new Location(getString(R.string.spa_name3),
                getString(R.string.spa_description3),
                getString(R.string.spa_opening3),
                getString(R.string.spa_opening_details3),
                getString(R.string.spa_contact3),
                getString(R.string.spa_website3),
                getString(R.string.spa_address3),
                R.drawable.rudas_thermal_bath));

        locations.add(new Location(getString(R.string.spa_name4),
                getString(R.string.spa_description4),
                getString(R.string.spa_opening4),
                getString(R.string.spa_opening_details4),
                getString(R.string.spa_contact4),
                getString(R.string.spa_website4),
                getString(R.string.spa_address4),
                R.drawable.platinum_bath));

        locations.add(new Location(getString(R.string.spa_name5),
                getString(R.string.spa_description5),
                getString(R.string.spa_opening5),
                getString(R.string.spa_opening_details5),
                getString(R.string.spa_contact5),
                getString(R.string.spa_website5),
                getString(R.string.spa_address5),
                R.drawable.aquaworld));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // create click listener for the items shown on screen
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected/clicked item position
                Location selectedItem = (Location) parent.getItemAtPosition(position);

                //create a new Intent which will open up a new layout in the app
                Intent intent = new Intent(getActivity(), LocationDetailsActivity.class);
                intent.putExtra(NAME, selectedItem.getLocationName());
                intent.putExtra(DESCRIPTION, selectedItem.getLocationDescription());
                intent.putExtra(OPENING_DETAILS, selectedItem.getLocationOpeningHoursDetails());
                intent.putExtra(CONTACT, selectedItem.getLocationContact());
                intent.putExtra(WEBSITE, selectedItem.getLocationWebsite());
                intent.putExtra(ADDRESS, selectedItem.getLocationAddress());
                intent.putExtra(IMAGE, selectedItem.getImageResourceId());

                startActivity(intent);
            }
        });

        return rootView;
    }
}

