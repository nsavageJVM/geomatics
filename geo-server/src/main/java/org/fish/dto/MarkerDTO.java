package org.fish.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by ubu on 06.06.17.
 */
@AllArgsConstructor
@Data
public class MarkerDTO {

    @JsonProperty("markers")
    private List<MarkerCoords> markerCoords;


}
