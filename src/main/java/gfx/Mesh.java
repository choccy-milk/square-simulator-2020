package gfx;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Mesh
{
    public static final Mesh QUAD = new Mesh(new float[]
    {
        -0.5F, -0.5F, 0,
        0.5F, -0.5F, 0,
        0.5F, 0.5F, 0,
        -0.5F, 0.5F, 0
    },
    new int[]
    {
        0, 1, 2,
        2, 3, 0
    });
    
    public static final Mesh TRIANGLE = new Mesh(new float[]
    {
        -0.5F, -0.5F, 0,
        0.5F, -0.5F, 0,
        0, 0.5F, 0
    },
    new int[]
    {
        0, 1, 2 
    });
    
    public static final Mesh CUBE = new Mesh(new float[]
    {
        // FRONT
        -0.5F, -0.5F, 0,
        0.5F, -0.5F, 0,
        0.5F, 0.5F, 0,
        -0.5F, 0.5F, 0,
        
        // LEFT
        -0.5F, -0.5F, 0,
        -0.5F, -0.5F, 1F,
        -0.5F, 0.5F, 1F,
        -0.5F, 0.5F, 0F,
        
        // RIGHT
        0.5F, -0.5F, 0,
        0.5F, -0.5F, 1F,
        0.5F, 0.5F, 1F,
        0.5F, 0.5F, 0F,
        
        // TOP
        -0.5F, -0.5F, 0,
        0.5F, -0.5F, 0,
        0.5F, -0.5F, 1,
        -0.5F, -0.5F, 1,
        
        // BOTTOM
        -0.5F, 0.5F, 0,
        0.5F, 0.5F, 0,
        0.5F, 0.5F, 1,
        -0.5F, 0.5F, 1
        
        // who needs a back amirite?
    },
    new int[]
    {
        0, 1, 2,
        2, 3, 0,
        
        4, 5, 6,
        6, 7, 4,
        
        8, 9, 10,
        10, 11, 8,
        
        12, 13, 14,
        14, 15, 12,
        
        16, 17, 18,
        18, 19, 16
    });
    
    private final int vertexBufferId;
    private final int indexBufferId;
    private final int length;
    
    public Mesh(float[] vertices, int[] indices)
    {
        vertexBufferId = glGenBuffers();
        indexBufferId = glGenBuffers();
        length = indices.length;
        storeFloatData(vertexBufferId, vertices, 0, 3);
        storeIntData(indexBufferId, indices);
    }
    
    public void render()
    {
        glEnableVertexAttribArray(0);
        glDrawElements(GL_TRIANGLES, length, GL_UNSIGNED_INT, 0);
        glDisableVertexAttribArray(0);
    }
    
    private void storeFloatData(int id, float[] data, int index, int count)
    {
        glBindBuffer(GL_ARRAY_BUFFER, id);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
        glVertexAttribPointer(index, count, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }
    
    private void storeIntData(int id, int[] data)
    {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, data, GL_STATIC_DRAW);
    }
}