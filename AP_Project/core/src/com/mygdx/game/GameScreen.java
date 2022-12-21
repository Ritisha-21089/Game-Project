package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import org.junit.Test;

public class GameScreen implements Screen {
    public MyGame Game;
    protected Texture game;
    public int i,j;
    protected SpriteBatch batch;
    private Skin skin;
    private Stage stage;
    //private Body box;

    public Rectangle tank1;
    public Rectangle tank2;
    private Texture tank1image;
    private Texture tank2image;

    public Texture health;
    private Texture tothealth;
    public Texture health2;
    private TextButton Pause;

    private InputEvent event;
    private OrthographicCamera cam;
    private World world;
    private Box2DDebugRenderer debug;
    public Vector2 gravity;
    private final float TIMESTEP = 1/60f;
    private final int VELOCITYITERATIONS = 8, POSITIONITERATION = 3;
    public GameScreen(MyGame Game){
        this.Game = Game;
        game = new Texture("bluebg.png");
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 640, 480);
        stage = new Stage(new StretchViewport(640,480,cam));
        skin = new Skin(Gdx.files.internal("default/skin/uiskin.json"));



    }

    @Override
    public void show() {
        world = new World(new Vector2(0, -9.81f), true);
        debug =  new Box2DDebugRenderer();
        batch = new SpriteBatch();
        tank1image = new Texture(Gdx.files.internal("helios_tank.png"));
        tank2image = new Texture(Gdx.files.internal("frost_tank.png"));
        Gdx.input.setInputProcessor(stage);
        stage.clear();
        Game.batch.setProjectionMatrix(cam.combined);
        stage.draw();

        //GROUND
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0,0);
        //Ground Shape
        ChainShape groundshape = new ChainShape();
        groundshape.createChain(new Vector2[]{new Vector2(-1000,100), new Vector2(1000,100)});

        //fixture def
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = groundshape;
        fixtureDef.friction = .5f;
        fixtureDef.restitution = 0;

        world.createBody(bodyDef).createFixture(fixtureDef);
        groundshape.dispose();

        /*
        //TANK BOX
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(2.5f,10);
        PolygonShape boxshape = new PolygonShape();
        boxshape.setAsBox(0.5f,1);
        //fixture
        fixtureDef.shape = boxshape;
        fixtureDef.friction = .75f;
        fixtureDef.restitution = 0.1f;
        fixtureDef.density = 50;

        box = world.createBody(bodyDef);
        box.createFixture(fixtureDef);
        boxshape.dispose(); */

        tank1 = new Rectangle();
        tank1.x = 0;
        tank1.y = 100;
        tank1.width = 9;
        tank1.height = 7;

        tank2 = new Rectangle();
        tank2.x = 500;
        tank2.y = 100;
        tank2.width = 9;
        tank2.height = 7;

        //creations of the health bars
        initTestObjects();
        //CHECK FOR GAME OVER : APPLICATION OF JUNIT TESTING

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        stage.act(delta);
        Game.batch.begin();
        Game.batch.draw(game,0,0,640,480);
        Game.batch.end();
        stage.act();
        stage.draw();


        debug.render(world,cam.combined);
        world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATION);
        Pause();

        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(tank1image, tank1.x, tank1.y);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.A)){ tank1.x -= 200 * Gdx.graphics.getDeltaTime();}
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {tank1.x += 200 * Gdx.graphics.getDeltaTime();}

        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(tank2image, tank2.x, tank2.y);
        batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){ tank2.x -= 200 * Gdx.graphics.getDeltaTime();}
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {tank2.x += 200 * Gdx.graphics.getDeltaTime();}

        batch.begin();
        batch.draw(tothealth,60,440,200,25);
        i = 40;
        batch.draw(health,63,443,i,20); //width =i for update
        if(i>200)
        {
            i=0;
        }
        i++;

        batch.end();

        batch.begin();
        j = 50;
        batch.draw(tothealth,360,440,200,25);
        batch.draw(health2,363,443,j,20);
        if(j>200)
        {
            j=0;
        }
        i++;

        batch.end();
    }


/////////////////////////////////////HEALTH BAR FUNCTIONS////////////////////////////////////
private void initTestObjects() {

    int width =1 ;
    int height = 1;
    Pixmap h = createProceduralPixmap(width, height,1,0,0);
    Pixmap total = createProceduralPixmap(width, height,0,1,0);
    Pixmap h2 = createProceduralPixmap(width, height,1,0,0);

    health = new Texture(h);
    tothealth = new Texture(total);

    health2 = new Texture(h2);

}

    private Pixmap createProceduralPixmap (int width, int height,int r,int g,int b) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);

        pixmap.setColor(r, g, b, 1);
        pixmap.fill();

        return pixmap;
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
        world.dispose();

    }

    private void Pause(){
        Pause = new TextButton("pause", skin);
        Pause.setPosition(288,418);
        Pause.setSize(50,50);
        Pause.setColor(0,0,0,0);
        stage.addActor(Pause);

        Pause.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Game.setScreen(new Pause((Game)));
            }
        });
}

    /*private class HealthBar {
        public int updateHealth(MyGame game) {
            batch.draw(health,63,443,i,20); //width =i for update
            batch.draw(health2,363,443,j,20);

            return i*j;
        }
    }*/
}
