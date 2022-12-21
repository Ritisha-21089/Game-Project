import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGame;


public class HealthBar extends GameScreen implements Screen {

    public HealthBar(MyGame Game) {
        super(Game);
    }
    public int updateHealth(MyGame Game){
        batch.draw(health,63,443,i,20); //width =i for update
        batch.draw(health2,363,443,j,20);

        return i*j;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
