package diamond.paint.copypaste;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.vecmath.Vector2d;

import diamond.doc.DocHolder;
import diamond.paint.EditMode;
import diamond.paint.core.GraphicMouseAction;
import diamond.paint.core.PaintContext;
import diamond.paint.creasepattern.CreasePattern;
import diamond.paint.geometry.GeometricOperation;
import diamond.paint.geometry.NearestVertexFinder;
import diamond.value.OriLine;

public class PasteAction extends GraphicMouseAction {


	private OriginHolder originHolder = OriginHolder.getInstance();

	private FilledOriLineArrayList shiftedLines = new FilledOriLineArrayList(0);


	double diffX, diffY;


	Line2D.Double g2dLine = new Line2D.Double();



	public PasteAction(){
		setEditMode(EditMode.INPUT);
		setNeedSelect(true);

		setActionState(new PastingOnVertex());

	}


	/**
	 * Clear context and mark lines as unselected.
	 */
	@Override
	public void destroy(PaintContext context) {
		context.clear(true);
		context.finishPasting();
	}


	@Override
	public void onDrag(PaintContext context, AffineTransform affine,
			boolean differentAction) {

	}


	@Override
	public void onDraw(Graphics2D g2d, PaintContext context) {

		super.onDraw(g2d, context);

		drawPickCandidateVertex(g2d, context);

		Vector2d origin = originHolder.getOrigin(context);

		if(origin == null){
			return;
		}


		double ox = origin.x;
		double oy = origin.y;

		g2d.setColor(Color.GREEN);
		drawVertex(g2d, context, ox, oy);

		if(context.pickCandidateV != null){
			diffX = context.pickCandidateV.x - ox;
			diffY = context.pickCandidateV.y - oy;
		}
		else {
			diffX = context.getLogicalMousePoint().x - ox;
			diffY = context.getLogicalMousePoint().y -oy;
		}
		g2d.setColor(Color.MAGENTA);

		//		GeometricOperation.shiftLines(context.getLines(), shiftedLines,
		//				current.x - ox, current.y -oy);
		//		
		//		for(OriLine line : shiftedLines){
		//			this.drawLine(g2d, line);
		//		}

		// a little faster
		for(OriLine l : context.getLines()){

			g2dLine.x1 = l.p0.x + diffX;
			g2dLine.y1 = l.p0.y + diffY;

			g2dLine.x2 = l.p1.x + diffX;
			g2dLine.y2 = l.p1.y + diffY;

			g2d.draw(g2dLine);
		}

	}



	@Override
	public Vector2d onMove(PaintContext context, AffineTransform affine,
			boolean differentAction) {

		// vertex-only super's action
		setCandidateVertexOnMove(context, differentAction);
		Vector2d closeVertex = context.pickCandidateV;


		Vector2d closeVertexOfLines = 
				GeometricOperation.pickVertexFromPickedLines(context);

		if(closeVertex == null){
			closeVertex = closeVertexOfLines;
		}


		Point2D.Double current = context.getLogicalMousePoint();
		if(closeVertex != null && closeVertexOfLines != null){
			// get the nearest to current
			closeVertex = NearestVertexFinder.findNearestOf(
					current, closeVertex, closeVertexOfLines);

		}

		context.pickCandidateV = closeVertex;

//		if (context.getLineCount() > 0) {
//			if(closeVertex == null) {
//				closeVertex = new Vector2d(current.x, current.y);
//			}
//
//		}		
		return closeVertex;
	}
	@Override
	public void onPress(PaintContext context, AffineTransform affine,
			boolean differentAction) {
	}
	@Override
	public void onRelease(PaintContext context, AffineTransform affine, boolean differentAction) {


	}

	@Override
	public void recover(PaintContext context) {
		context.clear(false);


		context.startPasting();

        CreasePattern creasePattern = DocHolder.getDoc().getCreasePattern();

		for(OriLine line : creasePattern){
			if(line.selected){
				context.pushLine(line);
			}
		}

		shiftedLines = new FilledOriLineArrayList(context.getLines());

	}



}
