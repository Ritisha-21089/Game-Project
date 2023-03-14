import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Bullets extends Lab1 implements Cloneable, InputProcessor {

    private Integer damage;
    private Double radius;
    private Integer mass;
    private Body bulbody;
    private Sprite bulSprite;
    public Bullets(Integer positionX, Integer positionY, World world) {
        bulSprite = new Sprite(new Texture("circle.png"));
        bulSprite.setSize(34, 34);
        createbulbody(positionX, positionY, world);
        
    }
    
    public Bullets() {}
    
    public Bullets (int damage, double radius, int mass) {
        this.damage = damage;
        this.radius = radius;
        this.mass = mass;
    }
    
   /* public float moveBullet(int u, int theta){
        Gdx.input.setInputProcessor(this);
        float range = (float) (u*u*Math.sin(2*theta*(Math.PI)/180)/9.81);
        return range;
        } */

     public void createbulBody(Integer positionX, Integer positionY, World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(positionX, positionY);
        bulBody = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(5);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = 1f;

        bulBody.createFixture(fixtureDef).setUserData("bomb");
        circleShape.dispose();
    }

     public double convertToRadians(float angle) {
        return Math.PI * angle / 180.0;
    }

     public void fire(float power, float angle) {
        angle = (float) convertToRadians(angle);
        float x = power * (float) Math.cos(angle);
        float y = power * (float) Math.sin(angle);
        Vector2 impulse = new Vector2(x, y);
        bulBody.applyLinearImpulse(impulse, bulBody.getWorldCenter(), true);
    }
    
     public void updateImage(SpriteBatch batch) {
        int x = (int) bulBody.getWorldCenter().x;
        int y = (int) bulBody.getWorldCenter().y;
        bulSprite.setPosition(x - 16 , y - 16);
        bulSprite.draw(batch);
    }
    
   @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

//DESIGN PATTERN : PROTOTYPE (CLONE)
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Bullets bomb = new Bullets();
        try {
            Bullets bomb2 = Lab1.getclone(bomb);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        moveBullet(30,45);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    //DESIGN PATTERN : ITERATOR
    public void iterator(){
        for (int i=0;i<bul.size();i++){
            bul.get(i);
        }
    }
}




