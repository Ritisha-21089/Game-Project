import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGame;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthBarTest extends GameScreen{

    public HealthBarTest(MyGame Game) {
        super(Game);
    }

    @Test
    public void TestZero() {
        HealthBar test = new HealthBar(Game);
        test.updateHealth(Game);
        assertNotEquals(0, test.updateHealth(Game));


    }
}