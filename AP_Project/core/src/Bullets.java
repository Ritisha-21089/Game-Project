import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Bullets extends Lab1 implements Cloneable, InputProcessor {

    public static ArrayList<Sprite> bul=new ArrayList<>();
    public Bullets() {
        Texture bombT = new Texture("circle.png");
        Sprite bomb = new Sprite(bombT);
        bomb.setSize(50, 50);
        bomb.setPosition(0,0);
        bul.add(bomb);
    }
    public float moveBullet(int u, int theta){
        Gdx.input.setInputProcessor(this);
        float range = (float) (u*u*Math.sin(2*theta*(Math.PI)/180)/9.81);
        return range;
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




