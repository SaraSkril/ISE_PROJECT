package Geometries;
import jdk.jshell.spi.ExecutionControl;
import Primitives.Point3D;
import Primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class geomitries implements Intersectable
{
    LinkedList<Intersectable> shapes;

    public geomitries(Intersectable... Geometries)
    {
        shapes=new LinkedList<Intersectable>();
        /** LinkedList chosen over ArrayList because it is easier to insert and delete items **/
        if (Geometries.length > 0)
            add(Geometries);
    }
    public void add(Intersectable... Geometries)
    {
        for (Intersectable var : Geometries)
        {
            shapes.add(var);
        }

    }


    @Override
    public List<Point3D> findIntsersections(Ray ray)
    {
        return null;
    }
}
