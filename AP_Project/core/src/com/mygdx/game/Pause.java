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

public class Pause implements Screen {
    MyGame pause;
    private Texture Pscreen;
    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;
    private TextButton resume;
    private TextButton exit;
    private InputEvent event;
    private OrthographicCamera PCam;

    public Pause(MyGame pause){

        this.pause = pause;
        Pscreen = new Texture("PAUSE_GAMEPLAY.png");
        PCam = new OrthographicCamera();
        stage = new Stage(new StretchViewport(640,480,PCam));
        skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        stage.clear();
        stage.draw();
        pause.batch.setProjectionMatrix(PCam.combined);
        stage.draw();


    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        pause.batch.begin();
        pause.batch.draw(Pscreen,0,0,640,480);
        pause.batch.end();
        stage.act();
        stage.draw();

        Resume();
        Exit();


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
    private void Resume(){
        resume = new TextButton("resume", skin);
        resume.setPosition(260,308);
        resume.setSize(120,50);
        resume.setColor(0,0,0,0);
        stage.addActor(resume);

        resume.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                pause.setScreen(new GameScreen((pause)));
            }
        });
    }

    private void Exit(){
        exit = new TextButton("EXIT", skin);
        exit.setPosition(260,150);
        exit.setSize(120,50);
        exit.setColor(0,0,0,0);
        stage.addActor(exit);

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.exit(0);
            }
        });
    }



}
