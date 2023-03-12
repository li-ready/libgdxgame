package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.input.*;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Music music;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		if(Gdx.input.isTouched()){
			if(music!=null)
			{
			  	music.dispose();
			}
			int x=Gdx.input.getX();int y=Gdx.input.getY();
			if(x<200&&x>0)
			{
				music = Gdx.audio.newMusic(Gdx.files.internal("assets/music1.mp3"));
				music.play();
			}
			if(x<600&&x>400)
			{
				music = Gdx.audio.newMusic(Gdx.files.internal("assets/music2.mp3"));
				music.play();
			}
			if(x<400&&x>200) {
				Sound sound = Gdx.audio.newSound(Gdx.files.internal("assets/good job.ogg"));
				sound.play(1.0f);
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
