package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Start implements Screen {
    private MyGame start;
    private Texture textHome;

    private Stage stage;
    private SpriteBatch batch;


    public Start(MyGame start) {
        this.start = start;
        textHome = new Texture("homescreen_game.png");

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(start.stage);

    }

    @Override
    public void render(float delta) {

        start.batch.begin();
        start.batch.draw(textHome,0,0,640,480);
        start.batch.end();
        if(Gdx.input.isTouched()){
            start.setScreen(new LogIn(start));
        }
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
        batch.dispose();

    }
}


