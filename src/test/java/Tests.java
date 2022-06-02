import Model.Checks;
import Model.Constants;
import Model.Field;
import net.synedra.validatorfx.Check;
import org.junit.jupiter.api.Test;

import static Model.Checks.checkStatus;

public class Tests {

    private static Field getNewFieldOne() {
        Field newField = new Field();
        newField.slot11.belonging = Constants.BluePlayer;
        newField.slot11.isNotEmpty = false;
        newField.slot12.belonging = Constants.BluePlayer;
        newField.slot12.isNotEmpty = false;
        newField.slot13.belonging = Constants.BluePlayer;
        newField.slot13.isNotEmpty = false;
        newField.slot14.belonging = Constants.BluePlayer;
        newField.slot14.isNotEmpty = false;
        return newField;
    }

    @Test

    public void blueVictoryOnTheHorizontalLine_checkStatus(){

    }
}
