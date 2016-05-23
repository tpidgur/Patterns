package _6Adapter;

import java.util.Random;

/**
 * Created by Зая on 22.05.2016.
 */
public class _6AdapterApp {
    public static void main(String[] args) {
        //1й способ через наследование
        VectorGraphicsInterface vectorGraphics = new VectorAdapterFromRaster();
        vectorGraphics.drawLine();
        vectorGraphics.drawSquare();
        //2й способ через композицию
        VectorGraphicsInterface vectorGraphics2 = new VectorAdapterFromRaster2();
        vectorGraphics2.drawLine();
        vectorGraphics2.drawSquare();

        VectorGraphicsInterface vectorGraphics3 = new VectorAdapterFromRaster3(new RasterGraphics());
        vectorGraphics3.drawLine();
        vectorGraphics3.drawSquare();

    }
}

interface VectorGraphicsInterface {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw a line");
    }

    void drawRasterSquare() {
        System.out.println("Draw a square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
class VectorAdapterFromRaster3 implements VectorGraphicsInterface {
    RasterGraphics raster = null    ;

    public VectorAdapterFromRaster3(RasterGraphics raster) {
        this.raster = raster;
    }

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}