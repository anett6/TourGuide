package com.example.android.tourguide;

/**
 * {@link Location} represents informations that the user wants to know.
 * It contains a the name, description, address, opening hours, contact from that location of the city
 * + image resource ID for the image.
 **/
public class Location {

    /** Location name*/
    private String mLocationName;

    /** Location description*/
    private String mLocationDescription;

    /**Location opening hours*/
    private String mLocationOpeningHours;

    /**Location opening hours with more details*/
    private String mLocationOpeningHoursDetails;

    /**Location contact*/
    private String mLocationContact;

    /**Location website*/
    private String mLocationWebsite;

    /**Location address*/
    private String mLocationAddress;

    /** Image resource ID for the location */
    private int mImageResourceId;

    /**
     * public= classes outside of the Location class can access these methods.
     * Constructor - Create a new Location object.
     *
     * @param locationName                is the name of the location/place
     * @param locationDescription         is a full, detailed description of the location
     * @param locationOpeningHours        is the time, when the location/place is opened
     * @param locationOpeningHoursDetails is a more detailed opening hours for the location
     * @param locationContact             is a phone number what you can call
     * @param locationWebsite             is a website, where you can find more informations
     * @param locationAddress             where you can find the location
     * @param locationImageResourceId     is the drawable resource ID for the image associated with the location/place
     **/
    public Location(String locationName, String locationDescription, String locationOpeningHours,
                    String locationOpeningHoursDetails, String locationContact, String locationWebsite,
                    String locationAddress, int locationImageResourceId) {

        mLocationName = locationName;
        mLocationDescription = locationDescription;
        mLocationOpeningHours = locationOpeningHours;
        mLocationOpeningHoursDetails = locationOpeningHoursDetails;
        mLocationContact = locationContact;
        mLocationWebsite = locationWebsite;
        mLocationAddress = locationAddress;
        mImageResourceId = locationImageResourceId;
    }

    //Get location name
    public String getLocationName() {
        return mLocationName;
    }

    //Get location description
    public String getLocationDescription() {
        return mLocationDescription;
    }

    //Get location opening hours
    public String getLocationOpeningHours() {
        return mLocationOpeningHours;
    }

    //Get location opening hours with more details
    public String getLocationOpeningHoursDetails() {
        return mLocationOpeningHoursDetails;
    }

    //Get location contact
    public String getLocationContact() {
        return mLocationContact;
    }

    //Get location website
    public String getLocationWebsite() {
        return mLocationWebsite;
    }

    //Get location address
    public String getLocationAddress() {
        return mLocationAddress;
    }

    //Get location image resource id
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "mLocationName='" + mLocationName + '\'' +
                ", mLocationDescription='" + mLocationDescription + '\'' +
                ", mLocationOpeningHours='" + mLocationOpeningHours + '\'' +
                ", mLocationOpeningHoursDetails='" + mLocationOpeningHoursDetails + '\'' +
                ", mLocationContact='" + mLocationContact + '\'' +
                ", mLocationWebsite='" + mLocationWebsite + '\'' +
                ", mLocationAddress='" + mLocationAddress + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
