package com.star4droid.skin.composer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import java.io.File;
import com.ray3k.skincomposer.FilesDroppedListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.ray3k.skincomposer.CloseListener;
import java.util.List;
import com.badlogic.gdx.files.FileHandle;
import com.ray3k.skincomposer.DesktopWorker;

public class Worker implements DesktopWorker {
	@Override
    public void texturePack(Array<FileHandle> handles, FileHandle localFile, FileHandle targetFile, FileHandle settingsFile) {
		Json json = new Json();
		TexturePacker.Settings settings = json.fromJson(TexturePacker.Settings.class, settingsFile);
		
		TexturePacker p = new TexturePacker(settings);
		for (FileHandle handle : handles) {
			if (handle.exists()) {
				p.addImage(handle.file());
				} else {
				if (localFile != null) {
					FileHandle localHandle = localFile.sibling(localFile.nameWithoutExtension() + "_data/" + handle.name());
					if (localHandle.exists()) {
						p.addImage(localHandle.file());
						} else {
						Gdx.app.error(getClass().getName(), "File does not exist error while creating texture atlas: " + handle.path());
					}
					} else {
					Gdx.app.error(getClass().getName(), "File does not exist error while creating texture atlas: " + handle.path());
				}
			}
		}
		p.pack(targetFile.parent().file(), targetFile.nameWithoutExtension());
	}

	@Override
	public void writeFont(FreeTypeFontGenerator.FreeTypeBitmapFontData arg0, Array<PixmapPacker.Page> arg1, FileHandle arg2) {
		
	}

	@Override
	public void packFontImages(Array<FileHandle> arg0, FileHandle arg1) {
	}

	@Override
	public void sizeWindowToFit(int arg0, int arg1, int arg2, Graphics arg3) {
	}

	@Override
	public void centerWindow(Graphics arg0) {
	}

	@Override
	public void addFilesDroppedListener(FilesDroppedListener arg0) {
	}

	@Override
	public void removeFilesDroppedListener(FilesDroppedListener arg0) {
	}

	@Override
	public void setCloseListener(CloseListener arg0) {
	}

	@Override
	public void attachLogListener() {
	}

	@Override
	public List<File> openMultipleDialog(String arg0, String arg1, String arg2, String arg3) {
	    return null;
	}

	@Override
	public File openDialog(String arg0, String arg1, String arg2, String arg3) {
	    return null;
	}

	@Override
	public File saveDialog(String arg0, String arg1, String arg2, String arg3) {
	    return null;
	}

	@Override
	public char getKeyName(int arg0) {
	    return 0;
	}

}