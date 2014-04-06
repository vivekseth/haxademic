package com.haxademic.app.haxmapper.mappers;

import java.util.ArrayList;

import oscP5.OscMessage;
import processing.core.PApplet;

import com.haxademic.app.haxmapper.HaxMapper;
import com.haxademic.app.haxmapper.MappingGroup;
import com.haxademic.app.haxmapper.polygons.IMappedPolygon;
import com.haxademic.app.haxmapper.textures.TextureColorAudioFade;
import com.haxademic.app.haxmapper.textures.TextureColorAudioSlide;
import com.haxademic.app.haxmapper.textures.TextureEQColumns;
import com.haxademic.app.haxmapper.textures.TextureEQGrid;
import com.haxademic.app.haxmapper.textures.TextureScrollingColumns;
import com.haxademic.app.haxmapper.textures.TextureShaderTimeStepper;
import com.haxademic.app.haxmapper.textures.TextureSphereRotate;
import com.haxademic.app.haxmapper.textures.TextureVideoPlayer;
import com.haxademic.core.system.FileUtil;

@SuppressWarnings("serial")
public class CMKY2014Mapper
extends HaxMapper{

//	protected int[] sideIndexes = {1,2,3,4,5,6,7,8};
//	protected int curSideIndex = 0;

	
	
	protected int numBeatsDetected = 0;

	public static void main(String args[]) {
		_isFullScreen = true;
		PApplet.main(new String[] { "--hide-stop", "--bgcolor=000000", "com.haxademic.app.haxmapper.mappers.CMKY2014Mapper" });
	}

	protected void overridePropsFile() {
		super.overridePropsFile();
		_appConfig.setProperty( "mapping_file", FileUtil.getHaxademicDataPath() + "text/mapping/mapping-2014-04-02-01-02-28.txt" );
	}

	public void oscEvent(OscMessage theOscMessage) {  
		super.oscEvent(theOscMessage);
	}

	protected void buildPolygonGroups() {

		MappingGroup centerGroup = _mappingGroups.get(0);
		centerGroup.pushTexture( _texturePool.get(0) );

		MappingGroup leftGroup = _mappingGroups.get(1);
		leftGroup.pushTexture( _texturePool.get(1) );
		leftGroup.pushTexture( _texturePool.get(3) );
		leftGroup.pushTexture( _texturePool.get(5) );
		leftGroup.pushTexture( _texturePool.get(7) );
		leftGroup.pushTexture( _texturePool.get(9) );
		leftGroup.pushTexture( _texturePool.get(10) );

		MappingGroup rightGroup = _mappingGroups.get(2);
		rightGroup.pushTexture( _texturePool.get(2) );
		rightGroup.pushTexture( _texturePool.get(4) );
		rightGroup.pushTexture( _texturePool.get(6) );
		rightGroup.pushTexture( _texturePool.get(8) );
		rightGroup.pushTexture( _texturePool.get(1) );
		rightGroup.pushTexture( _texturePool.get(3) );

		MappingGroup bottomGroup = _mappingGroups.get(3);
		bottomGroup.pushTexture( _texturePool.get(3) );


		// set initial mapping properties - make all fully contain their textures
		for(int i=0; i < _mappingGroups.size(); i++ ) {
			ArrayList<IMappedPolygon> polygons = _mappingGroups.get(i).polygons();
			for(int j=0; j < polygons.size(); j++ ) {
				IMappedPolygon polygon = polygons.get(j);
				polygon.setTextureStyle(true);
			}
		}

	}

	protected void addTexturesToPool() {

		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/smoke-loop.mov" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/tree-loop.mp4" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/ink-in-water.mp4" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/ink-grow-shrink.mp4" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/fire.mp4" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/bubbles.mp4" ));	
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/clouds-timelapse.mov" ));
		_texturePool.add( new TextureVideoPlayer( 640, 360, "video/loops/water.mp4" ));
		_texturePool.add( new TextureScrollingColumns( 100, 100 ));
		_texturePool.add( new TextureShaderTimeStepper( 400, 400, "wavy-checker-planes.glsl" ));
		_texturePool.add( new TextureShaderTimeStepper( 400, 400, "bw-eye-jacker-01.glsl" ));
		_texturePool.add( new TextureShaderTimeStepper( 400, 400, "dots-orbit.glsl" ));
		_texturePool.add( new TextureShaderTimeStepper( 400, 400, "glowwave.glsl" ));
		_texturePool.add( new TextureEQColumns( 200, 100 ));
		_texturePool.add( new TextureEQGrid( 320, 160 ));
		_texturePool.add( new TextureColorAudioFade( 100, 100 ));
		_texturePool.add( new TextureColorAudioSlide( 100, 100 ));
		_texturePool.add( new TextureSphereRotate( 400, 400 ));
		//			_texturePool.add( new TextureWebCam());

	}

	protected void bigChangeTrigger() {

		MappingGroup centerGroup = _mappingGroups.get(1);
//		centerGroup.shiftTexture();
//		centerGroup.pushTexture( _texturePool.get(0) );
		centerGroup.setAllPolygonsToTexture(0);
		
		// REMOVE ALL TEXTURE FROM A GROUP AND ADD A RANDOM SET
		// setAllPolygonsToTexture() yes!
		// THEN RANDOMIZE FROM THERE
		// ALSO< SET ALL POLYGON MAPPING ROTATION + STYLE

//		curSideIndex++;
//		if( curSideIndex >= sideIndexes.length ) {
//			curSideIndex = 0;
//		}

		MappingGroup leftGroup = _mappingGroups.get(0);
//		leftGroup.shiftTexture();
//		leftGroup.pushTexture( _texturePool.get(sideIndexes[curSideIndex]) );
		leftGroup.setAllPolygonsToTexture(0);

		MappingGroup rightGroup = _mappingGroups.get(2);
//		rightGroup.shiftTexture();
//		rightGroup.pushTexture( _texturePool.get(sideIndexes[curSideIndex]) );
		rightGroup.setAllPolygonsToTexture(0);

		MappingGroup bottomGroup = _mappingGroups.get(3);
//		bottomGroup.shiftTexture();
//		bottomGroup.pushTexture( _texturePool.get(sideIndexes[curSideIndex]) );
		bottomGroup.setAllPolygonsToTexture(0);

	}

	public void drawApp() {
		super.drawApp();
	}

	protected void checkBeat() {
		if( audioIn.isBeat() == true ) {
			numBeatsDetected++;
			
			for(int i=0; i < _mappingGroups.size(); i++ ) {
				_mappingGroups.get(i).randomizeNextPolygon();
			}

			if( numBeatsDetected % 10 == 0 ) {
				bigChangeTrigger();
			}
		}
	}
}