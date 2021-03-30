package objects;

import org.jogamp.java3d.BranchGroup;
import org.jogamp.java3d.Transform3D;
import org.jogamp.vecmath.Point3d;
import org.jogamp.vecmath.Point3f;
import org.jogamp.vecmath.Vector3d;

import jpanels.BasicView;
import lights.LightFactory;
import objects.poolballs.*;

public class PoolBallViewer extends BasicView {
	private static final long serialVersionUID = 1L;

	public PoolBallViewer() {
		Transform3D t = new Transform3D();
		t.lookAt(new Point3d(1,2,1), new Point3d(), new Vector3d(0,1,0));
		t.invert();
		setViewTransform(t);
	}

	@Override
	public BranchGroup createContent() {
		BranchGroup bg = new BranchGroup();
		
		bg.addChild(new AxisFrame());
		bg.addChild(LightFactory.createAmbientLight());
		bg.addChild(LightFactory.createPointLight(new Point3f(0.1f, 3, 0.1f)));
				
		bg.addChild(new RedBall(0, 0).getTG());
		bg.addChild(new YellowBall(0.5, 0).getTG());
		bg.addChild(new GreenBall(0, 0.5).getTG());
		bg.addChild(new BrownBall(0.5, 0.5).getTG());
		bg.addChild(new BlueBall(-0.5, 0).getTG());
		bg.addChild(new PinkBall(0, -0.5).getTG());
		bg.addChild(new BlackBall(-0.5, -0.5).getTG());
		bg.addChild(new CueBall(-0.5, 0.5).getTG());

		bg.compile();
		return bg;
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new jframes.Window(new PoolBallViewer(), "Pool Ball Tester");
            }
        });
	}

}