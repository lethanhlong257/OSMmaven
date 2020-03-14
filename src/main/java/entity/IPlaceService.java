package entity;

import models.Place;

import java.util.List;

public interface IPlaceService {
    int createNewPlace (Place place);
    void updatePlace(Place place);
    List listAllPlace();
}
