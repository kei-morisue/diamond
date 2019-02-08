/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.model.palette.cp;

import javax.vecmath.Vector2d;

import diamond.model.geom.element.cp.OriLine;
import diamond.model.geom.element.cp.OriPoint;
import diamond.model.geom.util.CrossPointUtil;
import diamond.model.palette.CreasePatternHolder;

/**
 * @author long_
 *
 */
public class LineClipper {//TBD seems wierd
    public static OriLine clipByCutLines(OriLine line) {
        OriPoint p0, p1;
        p0 = null;
        p1 = null;
        for (OriLine cutLine : CreasePatternHolder.getCP().getCutLines()) {
            Vector2d cp = CrossPointUtil.getCrossPoint(line, cutLine);
            if (cp != null) {
                if (p0 == null) {
                    p0 = new OriPoint(cp.x, cp.y);
                } else {
                    p1 = new OriPoint(cp.x, cp.y);
                }
            }
        }
        if (p0 != null && p1 != null) {
            return new OriLine(p0, p1, line.getType());
        }
        return line;
    }
}
