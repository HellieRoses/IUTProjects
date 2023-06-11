package fr.umontpellier.iut.rails.vues;

import fr.umontpellier.iut.rails.IDestination;
import fr.umontpellier.iut.rails.IJoueur;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;


/**
 * Cette classe présente les éléments des joueurs autres que le joueur courant,
 * en cachant ceux que le joueur courant n'a pas à connaitre.
 *
 * On y définit les bindings sur le joueur courant, ainsi que le listener à exécuter lorsque ce joueur change
 */
public class VueAutresJoueursHaut extends HBox {
    private Label pseudoJoueur;
    private VBox nonPP;
    private Label statutJoueur;
    private VBox destinations;
    private Label scoreJoueur;
    private ImageView imageJoueur;

    private String bgColor;
    public VueAutresJoueursHaut(){
        nonPP = new VBox();
        pseudoJoueur = new Label();
        statutJoueur = new Label();
        scoreJoueur = new Label();
        destinations = new VBox();
        imageJoueur = new ImageView();
        destinations.setAlignment(Pos.CENTER);
        destinations.setAlignment(Pos.CENTER);
        nonPP.getChildren().addAll(pseudoJoueur,statutJoueur);
        getChildren().addAll(imageJoueur, nonPP);
        setAlignment(Pos.CENTER);
        setMaxWidth(500);
        setSpacing(20);
        setPadding(new Insets(10));
        nonPP.setAlignment(Pos.CENTER);


    }

    public void setUp(IJoueur joueur){
        pseudoJoueur.setText(joueur.getNom());
        destinations.getChildren().clear();
        for (IDestination d : joueur.getDestinations()) {
            Label v = new Label(d.getVilles().toString());
            destinations.getChildren().add(v);
        }
        if(joueur.getCouleur().equals(IJoueur.CouleurJoueur.JAUNE)){
            setStyle("-fx-background-color:  #DEB35A");
            bgColor = "-fx-background-color:  #DEB35A";
            imageJoueur.setImage(new Image("images/cartesWagons/avatar-JAUNE.png"));
        } else if (joueur.getCouleur().equals(IJoueur.CouleurJoueur.BLEU)) {
            setStyle("-fx-background-color: #6198CE");
            bgColor = "-fx-background-color:  #6198CE";
            imageJoueur.setImage(new Image("images/cartesWagons/avatar-BLEU.png"));

        } else if (joueur.getCouleur().equals(IJoueur.CouleurJoueur.ROUGE)) {
            setStyle("-fx-background-color: #CE6956");
            bgColor = "-fx-background-color:  #CE6956";
            imageJoueur.setImage(new Image("images/cartesWagons/avatar-ROUGE.png"));

        }else if (joueur.getCouleur().equals(IJoueur.CouleurJoueur.VERT)) {
            setStyle("-fx-background-color: #A8BD5F");
            bgColor = "-fx-background-color:  #A8BD5F";
            imageJoueur.setImage(new Image("images/cartesWagons/avatar-VERT.png"));

        }else{
            setStyle("-fx-background-color: #CF78C6");
            bgColor = "-fx-background-color:  #CF78C6";
            imageJoueur.setImage(new Image("images/cartesWagons/avatar-ROSE.png"));

        }
        statutJoueur.setText("Joue dans 2 tours");

        imageJoueur.setFitHeight(84); imageJoueur.setFitWidth(64.4);

        StringProperty stringScoreJoueur = new SimpleStringProperty();
        stringScoreJoueur.set("Score de " + joueur.getNom() + " : " + String.valueOf(joueur.getScore()));
        scoreJoueur.textProperty().bind(stringScoreJoueur);
    }

    public ImageView getImageJoueur(){
        ImageView imageJoueur2 = new ImageView();
        imageJoueur2.setImage(imageJoueur.getImage());
        imageJoueur2.setFitHeight(imageJoueur.getFitHeight());
        imageJoueur2.setFitWidth(imageJoueur.getFitWidth());
        return imageJoueur2;
    }

    public Label getScoreJoueur() {
        return scoreJoueur;
    }

    public VBox getDestinations() {
        return destinations;
    }

    public String getBgColor(){
        return  bgColor;
    }
    public Label getPseudoJoueur() {
        return pseudoJoueur;
    }
}



