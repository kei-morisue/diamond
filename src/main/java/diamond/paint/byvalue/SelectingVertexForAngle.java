package diamond.paint.byvalue;

import java.awt.geom.Point2D.Double;

import javax.vecmath.Vector2d;

import diamond.doc.DocHolder;
import diamond.paint.core.PaintContext;
import diamond.paint.core.PickingVertex;

public class SelectingVertexForAngle extends PickingVertex{
	
	private boolean doingFirstAction = true;
	
	public SelectingVertexForAngle(){
		super();
	}


	@Override
	public void onResult(PaintContext context) {
        
        Vector2d first = context.getVertex(0);
        Vector2d second = context.getVertex(1);
        Vector2d third = context.getVertex(2);
        
        Vector2d dir1 = new Vector2d(third);
        Vector2d dir2 = new Vector2d(first);
        dir1.sub(second);
        dir2.sub(second);

        double deg_angle = Math.toDegrees(dir1.angle(dir2));

        ValueDB valDB = ValueDB.getInstance();

        valDB.setAngle(deg_angle);
        valDB.notifyObservers();
 
 //       Globals.subLineInputMode = Constants.SubLineInputMode.NONE;

		
        doingFirstAction = true;
        context.clear(false);

        context.setMissionCompleted(true);
	}
	@Override
	protected void initialize() {
	}

	@Override
	protected boolean onAct(PaintContext context, Double currentPoint,
			boolean doSpecial) {
		
		context.setMissionCompleted(false);
		
		if(doingFirstAction){
			DocHolder.getDoc().cacheUndoInfo();
			doingFirstAction = false;
		}
		
		boolean result = super.onAct(context, currentPoint, doSpecial);
		
		if(result == true){
			if(context.getVertexCount() < 3){
				result = false;
			}
		}
		
		return result;
	}

	
}
