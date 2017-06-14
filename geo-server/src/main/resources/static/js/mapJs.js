function initMap() {

  console.log( "mapJs initMap loading" );

  // var wmsUrl ='http://localhost:8080/geoserver/osm/wms?';
  var wmsUrl ='http://geos:8080/geoserver/osm/wms?';
  var osmUrl = 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
  var satellite_Base ='//server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}.jpg';
  var wmsLayer1 = L.tileLayer.wms(wmsUrl, {layers: 'osm:planet_osm_line', format: 'image/png', transparent: true });
  var coolPlaces = new L.LayerGroup();
  var base = L.tileLayer(satellite_Base , {maxZoom: 19});

  var map = L.map('mapid', { maxZoom : 19,
                          layers: [base ],
                          scrollWheelZoom:'center',
                          attributionControl: false }).setView([43.2166700, 27.9166700], 14);


  var baseLayer = {"OSM Varna": base };
  customMarkers(coolPlaces)
  var roadLayer = {"Roads": wmsLayer1, "Interesting places": coolPlaces};

  L.control.layers( baseLayer, roadLayer).addTo( map);

  console.log( "mapJs initMap loaded" );


}


function customMarkers(customMarkersLayer) {
	$.ajax({
		url: '/boot/gis/markers',
		dataType: 'json',
		type: 'GET'
	}).done(function(markerArray) {
		try {

		  console.log( "gis markers callsback" );
			var markerJsonData;

			var tag;
			var latitude;
			var longitude;

			console.log( "gis markers markerArray "+ markerArray.markers.length);
			for (index = 0; index < markerArray.markers.length-1; index++) {
				markerJsonData = markerArray.markers[index];

				latitude = parseFloat(markerJsonData.latitude);
				longitude = parseFloat(markerJsonData.longitude);
				console.log("latitude " +latitude+" longitude "+longitude)

				if (latitude !== null && !isNaN(latitude) && longitude !== null && !isNaN(longitude)) {
                   if (customMarkersLayer !== null) {
                         var markerLocation = new L.LatLng(latitude  , longitude);
                         var marker = new L.Marker(markerLocation);
                         customMarkersLayer.addLayer(marker);
                         marker.bindPopup(markerJsonData.tag);
                   }


				}
			}
		console.log( "gis markers callsback done" );
		} catch (e) {
			window.console && console.log(e);
		}
	});
}