package snake.commun.monde2d;

import java.util.Random;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fruit2d extends Object2dFx {

	private static final double TAILLE = Terrain2dSnake.TAILLE_CASE;

	private final Random random = new Random();

	public Fruit2d() {
		super();
		setWidth(TAILLE);
		setHeight(TAILLE);
	}

	@Override
	public void onAddedToWorld() {

	}

	public void respawn(Serpent2d serpent) {
		int colonnes = (int) (getWorldWidth() / TAILLE);
		int lignes = (int) (getWorldHeight() / TAILLE);

		double caseX, caseY;
		do {
			caseX = random.nextInt(colonnes) * TAILLE;
			caseY = random.nextInt(lignes) * TAILLE;
		} while (serpent.occupeCase(caseX, caseY));

		setTopLeftX(caseX);
		setTopLeftY(caseY);
	}

	public boolean estMange(Serpent2d serpent) {
		double serpentX = serpent.getTopLeftX();
		double serpentY = serpent.getTopLeftY();
		double fruitX = getTopLeftX();
		double fruitY = getTopLeftY();

		return serpentX < fruitX + TAILLE && serpentX + TAILLE > fruitX
				&& serpentY < fruitY + TAILLE && serpentY + TAILLE > fruitY;
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		Image imageFruit = new Image(getClass().getResourceAsStream("/images/pomme.png"));
		gc.drawImage(imageFruit, getTopLeftX(), getTopLeftY(), TAILLE, TAILLE);
	}
}
