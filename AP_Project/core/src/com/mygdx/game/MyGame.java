package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGame extends Game {

	private Start start;
	public SpriteBatch batch;
	public Stage stage;

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new Start(this));

	}

	@Override
	public void render() {
		super.render();

	}

	@Override
	public void dispose() {
		batch.dispose();

	}
}
