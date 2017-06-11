package org.fish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ubu on 06.06.17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarkerCoords {

    private double latitude;
    private double longitude;
    private String tag;

}
