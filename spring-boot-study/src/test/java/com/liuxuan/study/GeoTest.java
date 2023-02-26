package com.liuxuan.study;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;
import com.vividsolutions.jts.simplify.DouglasPeuckerSimplifier;
import org.junit.jupiter.api.Test;

/**
 * @author: liuxuan
 * @date: 2023-02-08 21:49
 **/
public class GeoTest {

    @Test
    public void test1() throws ParseException {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
        WKTReader wktReader = new WKTReader(geometryFactory);
        Geometry geometry1 = wktReader.read("lineString(0 0, 1 1, 2 0)");
        Geometry geometry2 = DouglasPeuckerSimplifier.simplify(geometry1, 0.9);
        WKTWriter wktWriter = new WKTWriter();
        String res = wktWriter.write(geometry2);
        System.out.println(res);  //LINESTRING (0 0, 1 1, 2 0)
    }
}
