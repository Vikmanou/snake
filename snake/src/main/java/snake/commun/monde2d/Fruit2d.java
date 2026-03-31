package snake.commun.monde2d;

import java.util.List;
import java.util.Random;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import snake.commun.modeles.ModeleInventaire;

public class Fruit2d extends Object2dFx {

	private static final double TAILLE = Terrain2dSnake.TAILLE_CASE;

	private static final double DUREE_ANIMATION = 0.3;

	private final Random random = new Random();

	private ModeleInventaire modeleInventaire;
	private String imageActuelle = "pomme";

	private double secondesRestantesAnimationFruit = 0;

	public void setModeleInventaire(ModeleInventaire modeleInventaire) {
		this.modeleInventaire = modeleInventaire;
	}

	public Fruit2d() {
		super();
		setWidth(TAILLE);
		setHeight(TAILLE);
	}

	@Override
	public void onAddedToWorld() {

	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (secondesRestantesAnimationFruit > 0) {
			secondesRestantesAnimationFruit -= secondsElapsed;
			if (secondesRestantesAnimationFruit < 0)
				secondesRestantesAnimationFruit = 0;
		}
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

		if (modeleInventaire != null) {
			List<String> nomsImages = new java.util.ArrayList<>();
			for (var fruit : modeleInventaire.getFruitsAchetes()) {
				nomsImages.add(fruit.getImage());
			}

			imageActuelle = nomsImages.get(random.nextInt(nomsImages.size()));
		}

		secondesRestantesAnimationFruit = DUREE_ANIMATION;
	}

	public int getTailleBonusFruit() {
		for (var fruit : modeleInventaire.getFruitsAchetes()) {
			if (fruit.getImage().equals(imageActuelle)) {
				return fruit.getBonusTailleSerpent();
			}
		}

		return 1;
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
		Image imageFruit = new Image(getClass().getResourceAsStream("/images/fruits/" + imageActuelle + ".png"));

		double t = 1.0 - (secondesRestantesAnimationFruit / DUREE_ANIMATION);
		double nouveauTaille = TAILLE * t;
		double decalage = (TAILLE - nouveauTaille) / 2.0;

		gc.drawImage(imageFruit,
				getTopLeftX() + decalage,
				getTopLeftY() + decalage,
				nouveauTaille, nouveauTaille);
	}
}
