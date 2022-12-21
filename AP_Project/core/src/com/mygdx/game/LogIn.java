package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class LogIn implements Screen{
    MyGame login;
    private Texture log;
    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;
    private TextButton loginButton;
    private InputEvent event;
    private OrthographicCamera logCam;


    public LogIn(MyGame login){

        this.login = login;
        log = new Texture("login_screen.png");
        logCam = new OrthographicCamera();
        stage = new Stage(new StretchViewport(640,480,logCam));
        skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();
        stage.draw();
        login.batch.setProjectionMatrix(logCam.combined);
        stage.draw();
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        login.batch.begin();
        login.batch.draw(log,0,0,640,480);
        login.batch.end();
        stage.act();
        stage.draw();
        logButton();

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

    private void logButton(){
        loginButton = new TextButton("LOGIN", skin);
        loginButton.setPosition(280,180);
        loginButton.setSize(100,50);
        loginButton.setColor(0,0,0,0);
        stage.addActor(loginButton);

        loginButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                login.setScreen(new mainMenu((login)));
            }
        });
    }
}