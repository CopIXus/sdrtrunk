/*
 * *****************************************************************************
 * Copyright (C) 2026 CopIXus / RadioTAK
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ****************************************************************************
 */
package io.github.dsheirer.export;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DftFrameExporterTest
{
    @Test
    void downsampleLinearKeepsPeakAboveFloor()
    {
        float[] db = new float[1024];
        java.util.Arrays.fill(db, -80f);
        db[100] = -10f;
        double[] out = DftFrameExporter.downsampleLinear(db, 512);
        assertEquals(512, out.length);
        double max = 0;
        double min = Double.MAX_VALUE;
        for(double v : out)
        {
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        assertTrue(max > min * 10, "peak should dominate noise floor after linear conversion");
    }
}
