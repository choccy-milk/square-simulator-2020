package glfw;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window
{
    private static final Logger logger = LogManager.getLogger();
    private static long id;
    
    public static void init()
    {
        if(!glfwInit())
        {
            logger.fatal("GLFW initialization failed miserably.");
            System.exit(-1);
        }
        
        id = glfwCreateWindow(1024, 768, "Square Simulator 2020: Cube Edition", NULL, NULL);
        
        if(id == 0)
        {
            logger.fatal("Window creation fucked up somehow.");
            System.exit(-1);
        }
        
        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(id, vidMode.width() / 2 - 1024 / 2, vidMode.height() / 2 - 768 / 2);
        glfwMakeContextCurrent(id);
        GL.createCapabilities();
    }
    
    public static boolean closeRequested()
    {
        return glfwWindowShouldClose(id);
    }
    
    public static void keepAlive()
    {
        glfwPollEvents();
        glfwSwapBuffers(id);
    }
}