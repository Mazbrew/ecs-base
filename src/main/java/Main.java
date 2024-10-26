import javax.swing.text.html.parser.Entity;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

import Components.ComponentManager;
import Entities.EntityManager;
import Enums.EntityType;
import Globals.Global;
import Systems.SystemManager;

public class Main {

    public static void main(String args[]) {
        InitWindowProperties();

    }

    private static void InitWindowProperties() {
        InitWindow(Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT, Global.TITLE);
        SetTargetFPS(Global.FPS);

        Long startTime = System.nanoTime();
        Long currentTime;
        double deltaTime;
        int frames = 0;
        int fps = 0;

        while (!WindowShouldClose()) {
            if (IsKeyDown(KEY_UP)) {
                EntityManager.createEntityWithCount(EntityType.CIRCLE, 1000);
                ComponentManager.attachComponents();
            }

            if (IsKeyDown(KEY_DOWN)) {
                EntityManager.removeEntityWithCount(EntityType.CIRCLE, 1000);
            }

            BeginDrawing();

            frames++;

            currentTime = System.nanoTime();

            deltaTime = (currentTime - startTime) / 1_000_000_000.0;

            if (deltaTime >= 1.0) {
                fps = frames;
                frames = 0;
                startTime = currentTime;
            }

            ClearBackground(RAYWHITE);

            SystemManager.manage();

            DrawText(String.valueOf(fps), 0, 0, FONT_SDF, BLACK);
            DrawText(String.valueOf(EntityManager.getEntityIdList().size()), 0, 20, FONT_SDF, BLACK);

            EndDrawing();
        }

        CloseWindow();
    }
}