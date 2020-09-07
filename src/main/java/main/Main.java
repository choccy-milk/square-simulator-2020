package main;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glRotatef;

import gfx.Mesh;
import glfw.Window;

/**
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * AAAAAAAAAAAAAAAAAA
 * AAAAAAAAAA
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 * AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
 */
public class Main
{
    protected Main()
    {
        Window.init();
        
        while(!Window.closeRequested())
        {
            Window.keepAlive();
            render();
        }
        
        System.exit(0);
    }
    
    float temp;
    
    private void render()
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glRotatef((float)Math.toRadians(20), 1, 1, 1);
        glColor3f(0, 0, 1);
        Mesh.CUBE.render();
    }
}