package com.syncleus.vectrex;

import com.syncleus.spangraph.MapGraph;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import toxi.geom.XYZ;

/**
 * OctMapped indexes vertices in a Graph
 */
abstract public class OctMapGraph<X extends XYZ> extends MapGraph<X> {

    public interface DistanceFunction3 {

        public float get(XYZ a, XYZ b);


        /** allows an implementation to use early termination when
         * exceeding a minimum value than completely calculating the result
         */
        default public boolean lessThan(XYZ a, XYZ b, float minimum) {
            return get(a, b) < minimum;
        }

    }

    abstract protected OctMap<X, Edge> newEdgeMap();

    abstract protected OctMap<X, Vertex> newVertexMap();




}
