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

public class mainMenu implements Screen {
    MyGame main;
    private Texture menu;
    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;

    private TextButton SGButton;
    private TextButton NGButton;
    private TextButton ExitButton;
    private InputEvent event;
    private OrthographicCamera menuCam;
    public mainMenu(MyGame main){
        this.batch = new SpriteBatch();
        this.main = main ;
        menu = new Texture("MAIN MENU(AFTER LOGIN).PNG");
        menuCam = new OrthographicCamera();
        stage = new Stage(new StretchViewport(640,480,menuCam));
        skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();
        stage.draw();
        main.batch.setProjectionMatrix(menuCam.combined);
        stage.draw();

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        main.batch.begin();
        main.batch.draw(menu,0,0,640,480);
        main.batch.end();
        stage.act();
        stage.draw();
        SGButton();
        NGButton();
        ExitButton();


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

    private void SGButton(){
        SGButton = new TextButton("SG", skin);
        SGButton.setPosition(240,80);
        SGButton.setSize(150,80);
        SGButton.setColor(0,0,0,0);
        stage.addActor(SGButton);

        SGButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                main.setScreen(new mainMenu((main)));
            }
        });
    }

    private void NGButton(){
        NGButton = new TextButton("NG", skin);
        NGButton.setPosition(20,80);
        NGButton.setSize(150,80);
        NGButton.setColor(0,0,0,0);
        stage.addActor(NGButton);

        NGButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                main.setScreen(new GameScreen((main)));
            }
        });
    }

    private void ExitButton(){
            ExitButton = new TextButton("EXIT", skin);
        ExitButton.setPosition(460,80);
        ExitButton.setSize(150,80);
        ExitButton.setColor(0,0,0,0);
        stage.addActor(ExitButton);

        ExitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.exit(0);
            }
        });
    }
}
