SELECT ST_Extent(geom) FROM boundary_poly WHERE town = 'BOSTON';
SELECT ST_Area(ST_Union(geom)) FROM boundary_poly WHERE town = 'BOSTON';