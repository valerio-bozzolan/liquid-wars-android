//    This file is part of Liquid Wars.
//
//    Copyright (C) 2013 Henry Shepperd (hshepperd@gmail.com)
//
//    Liquid Wars is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Liquid Wars is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Liquid Wars.  If not, see <http://www.gnu.org/licenses/>.

package com.xenris.liquidwarsos;

import android.graphics.*;
import java.io.*;

public class ClientInfo {
    private static final Paint gPaint = new Paint();
    private int gId;
    private int gX;
    private int gY;
    private int gColor;
    private boolean gReady = false;
    private boolean gIsClients = false;

    public ClientInfo(int id) {
        gId = id;
        gColor = Color.BLUE;
    }

    public ClientInfo(int id, int colour) {
        gId = id;
        gColor = colour;
    }

    public ClientInfo(int id, int colour, boolean isClients) {
        gId = id;
        gColor = colour;
        gIsClients = isClients;
    }

    public int getId() {
        return gId;
    }

    public void setId(int id) {
        gId = id;
    }

    public int getX() {
        return gX;
    }

    public void setX(int x) {
        gX = x;
    }

    public int getY() {
        return gY;
    }

    public void setY(int y) {
        gY = y;
    }

    public int getColor() {
        return gColor;
    }

    public void setColor(int color) {
        gColor = color;
    }

    public boolean isReady() {
        return gReady;
    }

    public void setReady(boolean ready) {
        gReady = ready;
    }

    public ClientInfo(DataInputStream dataInputStream) throws IOException {
        gId = dataInputStream.readInt();
        gX = dataInputStream.readInt();
        gY = dataInputStream.readInt();
        gColor = dataInputStream.readInt();
        gReady = dataInputStream.readBoolean();
    }

    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(gId);
        dataOutputStream.writeInt(gX);
        dataOutputStream.writeInt(gY);
        dataOutputStream.writeInt(gColor);
        dataOutputStream.writeBoolean(gReady);
    }

    public void setValues(ClientInfo otherClientInfo) {
        gX = otherClientInfo.getX();
        gY = otherClientInfo.getY();
        gColor = otherClientInfo.getColor();
        gReady = otherClientInfo.isReady();
    }

    public void draw(Canvas canvas) {
        if(gIsClients) {
            gPaint.setColor(Color.RED);
            canvas.drawCircle(gX, gY, 50, gPaint);
        } else {
            gPaint.setColor(gColor);
            canvas.drawCircle(gX, gY, 200, gPaint);
        }
    }
}
