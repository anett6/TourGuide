package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationDetailsActivity extends AppCompatActivity {

    //to avoid hardcode and miss-type
    static final String NAME = "Name";
    static final String DESCRIPTION = "Description";
    static final String OPENING_DETAILS = "Opening_Details";
    static final String CONTACT = "Contact";
    static final String WEBSITE = "Website";
    static final String ADDRESS = "Address";
    static final String IMAGE = "Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);

        //Getting extra Strings: location NAME, DESCRIPTION for the place, OPENING_DETAILS hours,
        // CONTACT number, WEBSITE address, actual ADDRESS
        //Getting an integer: IMAGE Resource ID from Fragment
        final Intent mIntent = getIntent();
        String locationName = mIntent.getStringExtra(NAME);
        String locationDescription = mIntent.getStringExtra(DESCRIPTION);
        String locationOpeningHoursDetails = mIntent.getStringExtra(OPENING_DETAILS);
        String locationContact = mIntent.getStringExtra(CONTACT);
        String locationWebsite = mIntent.getStringExtra(WEBSITE);
        final String locationAddress = mIntent.getStringExtra(ADDRESS);
        int locationImage = mIntent.getIntExtra(IMAGE, 0);

        //Find the TextViews and an ImageView in the activity_location_details layout.
        TextView detailsLocationName = findViewById(R.id.location_name);
        TextView detailsLocationDescription = findViewById(R.id.location_description);
        TextView detailsLocationOpeningHoursDetails = findViewById(R.id.location_opening_hours);
        TextView detailsLocationContact = findViewById(R.id.location_contact);
        TextView detailsLocationWebsite = findViewById(R.id.location_website);
        TextView detailsLocationAddress = findViewById(R.id.location_address);
        ImageView detailsLocationImage = findViewById(R.id.location_image_view);

        //Set text and ImageResource ID on the Views what I found in activity_location_details layout
        detailsLocationName.setText(locationName);
        detailsLocationDescription.setText(locationDescription);
        detailsLocationOpeningHoursDetails.setText(locationOpeningHoursDetails);
        detailsLocationContact.setText(locationContact);
        detailsLocationWebsite.setText(locationWebsite);
        detailsLocationAddress.setText(locationAddress);
        detailsLocationImage.setImageResource(locationImage);

        // create click listener for the address to open up the map
        detailsLocationAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Create a URI from an intent string. Use the result to create an Intent.
                //geo: to display a map at the specified location
                //q=a place to highlight on the map, String should be URL-escaped, without spaces
                //android.net.Uri.parse - to encode the String
                Uri gmmIntentUri = android.net.Uri.parse("geo:0,0?q=" + Uri.encode(mIntent.getStringExtra(ADDRESS)));
                //Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW.
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                //Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");
                //if the result is not null, it`s safe to call startActivity()
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    //Attempt to start an activity that can handle the Intent
                    startActivity(mapIntent);
                }
            }
        });
    }
}