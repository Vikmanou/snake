package snake.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Terrain2dSnake extends Object2dFx {

	public static final double TAILLE_CASE = 20;

	private static final Color VERT_PALE = Color.web("#A2D149");
	private static final Color VERT_FONCE = Color.web("#94BF43");

	public Terrain2dSnake() {
		super();
		setTopLeftX(0);
		setTopLeftY(0);
	}

	@Override
	public void onAddedToWorld() {
		setWidth(getWorldWidth());
		setHeight(getWorldHeight());
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.clearRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

		gc.setFill(Color.web("#1a2b1a"));
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

		gc.setStroke(Color.web("#2d4a2d"));
		gc.setLineWidth(1.0);

		for (double x = getTopLeftX(); x < getTopLeftX() + getWidth(); x += TAILLE_CASE) {
			for (double y = getTopLeftY(); y < getTopLeftY() + getHeight(); y += TAILLE_CASE) {
				if ((int) ((x + y) / TAILLE_CASE) % 2 == 0) {
					gc.setFill(VERT_PALE);
				} else {
					gc.setFill(VERT_FONCE);
				}

				gc.fillRect(x, y, TAILLE_CASE, TAILLE_CASE);
			}
		}
	}

	public static double caseAPosition(double posXouY) {
		return Math.round(posXouY / TAILLE_CASE) * TAILLE_CASE;
	}
}
